package com.study.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.base.BaseController;
import com.study.dto.PageDTO;
import com.study.dto.ResponseVo;
import com.study.user.entity.User;
import com.study.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户账户表 前端控制器
 * </p>
 *
 * @author chengyin
 * @since 2017-11-28
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("")
    public JSONObject getUserList(PageDTO pageDTO,User user) {
        logger.info("page:"+pageDTO.toString());
        logger.info("user:"+user.toString());
        return pagingDataHandle(userService.selectUserPage(pageDTO,user));
    }


    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("")
    public ResponseVo postUser(User user){
        return userService.insertUser(user);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public ResponseVo putUser(@PathVariable Integer id, @RequestBody User user) {
        ResponseVo responseVo = new ResponseVo();
        User u = userService.selectById(id);
        u.setRealName(user.getRealName());
        u.setAccountName(user.getAccountName());
        responseVo.setSuccessful(userService.updateById(u));
        return responseVo;
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public ResponseVo deleteUser(@PathVariable Integer id) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setSuccessful(userService.deleteById(id));
        return responseVo;
    }
}
