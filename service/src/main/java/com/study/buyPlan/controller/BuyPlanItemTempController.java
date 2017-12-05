package com.study.buyPlan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.study.base.BaseController;
import com.study.buyPlan.entity.BuyPlanItemTemp;
import com.study.buyPlan.service.IBuyPlanItemTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<BuyPlanItemTemp> getList(BuyPlanItemTemp buyPlanItemTemp){
        return buyPlanItemTempService.selectList(new EntityWrapper<>(buyPlanItemTemp));
    }
}
