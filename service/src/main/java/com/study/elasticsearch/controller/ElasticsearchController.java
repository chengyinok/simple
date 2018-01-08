package com.study.elasticsearch.controller;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @创建人 chengyin
 * @创建时间 2018/1/8
 * @描述
 */
@RestController
@RequestMapping("/elastic")
public class ElasticsearchController {

    @Autowired
    private TransportClient client;

    /**
     * 查询接口
     * @param id
     * @return
     */
    @GetMapping("/get/book/novel")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name="id",defaultValue = "")String id){
        if(id.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = this.client.prepareGet("book","novel",id).get();
        if(!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }

    @PostMapping("/add/book/novel")
    @ResponseBody
    public ResponseEntity add(@RequestParam(name = "title") String title,
                              @RequestParam(name = "author") String author,
                              @RequestParam(name = "word_count") int wordCount,
                              @RequestParam(name = "publish_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishDate
                              ){
        IndexResponse result = null;
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title",title)
                    .field("author",author)
                    .field("word_count",wordCount)
                    .field("publish_date","2017-01-01")
                    .endObject();
            result = this.client.prepareIndex("book","novel")
                    .setSource(content)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(result.getId(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/book/novel")
    @ResponseBody
    public ResponseEntity delete(@RequestParam(name = "id") String id){
        DeleteResponse result = this.client.prepareDelete("book","novel",id).get();
        return new ResponseEntity(result.getResult().toString(),HttpStatus.OK);
    }

    @PutMapping("/update/book/novel")
    @ResponseBody
    public ResponseEntity update(@RequestParam("id") String id,
                                 @RequestParam(name = "title",required = false) String title,
                                 @RequestParam(name = "author",required = false) String author
                                 ){
        UpdateResponse result = null;
        UpdateRequest update = new UpdateRequest("book","novel",id);
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject();
            if(title!=null){
                content.field("title",title);
            }
            if(author!=null){
                content.field("author",author);
            }
            content.endObject();
            update.doc(content);
            result = this.client.update(update).get();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            return new ResponseEntity(result.getResult().toString(),HttpStatus.OK);
        }
    }

    @PostMapping("/query/book/novel")
    @ResponseBody
    public ResponseEntity query(@RequestParam(name = "author" ,required = false)String author,
                                @RequestParam(name = "title",required = false)String title,
                                @RequestParam(name = "gt_word_count",defaultValue = "0")int gtWordCount,
                                @RequestParam(name = "lt_word_count",required = false)Integer ltWordCount
                                ){
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if(author!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("author",author));
        }
        if(title!=null){
            boolQueryBuilder.must(QueryBuilders.matchQuery("title",title));
        }

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("word_count").from(gtWordCount);
        if(ltWordCount != null && ltWordCount > 0){
            rangeQuery.to(ltWordCount);
        }

        boolQueryBuilder.filter(rangeQuery);
        SearchRequestBuilder builder = this.client.prepareSearch("book")
                .setTypes("novel")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(boolQueryBuilder)
                .setFrom(0)
                .setSize(10);
        System.out.println(builder);
        SearchResponse response = builder.get();
        List<Map<String,Object>> result = new ArrayList<>();
        for(SearchHit hit : response.getHits()){
            result.add(hit.getSourceAsMap());
        }
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
