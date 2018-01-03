package com.study.system.service;

import com.study.system.entity.SysMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chengyin123
 * @since 2018-01-03
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取所有菜单
     * @return
     */
    List<SysMenu> getAllMenu();
}
