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
        return "index";
    }

    @GetMapping("/admin/user/list")
    public String adminUser(){
        return "/admin/user/list";
    }
}
