package com.study.buyPlan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.base.BaseController;
import com.study.buyPlan.entity.BuyPlanItemTemp;
import com.study.buyPlan.service.IBuyPlanItemTempService;
import com.study.dto.BootstrapTablePage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chengyin
 * @since 2017-12-05
 */
@RestController
@RequestMapping("/buyPlan")
public class BuyPlanItemTempController extends BaseController{

    @Autowired
    private IBuyPlanItemTempService buyPlanItemTempService;

    @GetMapping("")
    public Map<String,Object> getList(BootstrapTablePage bootstrapTablePage, BuyPlanItemTemp buyPlanItemTemp){
        Map<String,Object> result = new HashMap<>();
        EntityWrapper<BuyPlanItemTemp> entityWrapper = new EntityWrapper<>(buyPlanItemTemp);
        if(StringUtils.isNotBlank(bootstrapTablePage.getOrder()) && StringUtils.isNotBlank(bootstrapTablePage.getSort())){
            entityWrapper.orderBy(bootstrapTablePage.getSort(),bootstrapTablePage.getOrder().equals("asc") ? true : false);
        }
        if(bootstrapTablePage.getLimit() != null && bootstrapTablePage.getOffset() != null){
            Page<BuyPlanItemTemp> page = new Page<>(bootstrapTablePage.getOffset()/bootstrapTablePage.getLimit() + 1,bootstrapTablePage.getLimit());
            page = buyPlanItemTempService.selectPage(page,entityWrapper);
            result.put("total",page.getTotal());
            result.put("rows",page.getRecords());
        }else{
            List<BuyPlanItemTemp> buyPlanItemTemps = buyPlanItemTempService.selectList(entityWrapper);
            result.put("total",buyPlanItemTemps.size());
            result.put("rows",buyPlanItemTemps);
        }
        return result;
    }
}
