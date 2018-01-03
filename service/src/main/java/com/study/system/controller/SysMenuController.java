package com.study.system.controller;


import com.study.system.entity.SysMenu;
import com.study.system.service.SysMenuService;
import io.swagger.annotations.ApiOperation;
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
 * @author chengyin123
 * @since 2018-01-03
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value="获取菜单列表", notes="")
    @GetMapping("/getAllMenu")
    public List<SysMenu> getAllMenu(){
        return sysMenuService.getAllMenu();
    }


}

