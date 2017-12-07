package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @创建人 chengyin
 * @创建时间 2017/12/1
 * @描述
 */
@Controller
public class WebRouterController {

    @GetMapping("/login")
    public String login(ModelMap map) {
        return "login";
    }

    @GetMapping("/index")
    public String adminIndex(){
        return "admin/index";
    }

    /**
     * 用户列表
     * @return
     */
    @GetMapping("/admin/user/list")
    public String listUser(){
        return "admin/user/list";
    }

    /**
     * 用户新增
     * @return
     */
    @GetMapping("/admin/user/add")
    public String addUser(){
        return "admin/user/add";
    }

    @GetMapping("/buyPlan/list")
    public String listBuyPlan(){
        return "buyPlan/list";
    }

    @GetMapping("/buyPlan/listd")
    public String listBuyPland(){
        return "buyPlan/list_d";
    }

}
