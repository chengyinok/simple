package com.study.user.controller;

import com.study.dto.ResponseVo;
import com.study.user.entity.User;
import com.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户账户表 前端控制器
 * </p>
 *
 * @author chengyin
 * @since 2017-11-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @PostMapping("/save")
    public ResponseVo save(User user){
        ResponseVo responseVo = new ResponseVo();
        boolean result = userService.insertOrUpdate(user);
        responseVo.setSuccessful(result);
        return responseVo;
    }
}
