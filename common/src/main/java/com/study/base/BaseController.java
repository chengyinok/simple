package com.study.base;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: chengyin
 * Date: 2017-12-02
 * Time: 15:11
 */
public abstract class BaseController {

    public JSONObject pagingDataHandle(Page page){
        JSONObject params = new JSONObject();
        params.put("code",0);
        params.put("count",page.getTotal());
        params.put("data",page.getRecords());
        params.put("msg","");
        return params;
    }
}
