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
    public String index(ModelMap map) {
        return "login";
    }
}
