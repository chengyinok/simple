package com.study.system.dao;

import com.study.system.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chengyin123
 * @since 2018-01-03
 */
public interface SysMenuDao extends BaseMapper<SysMenu> {

    /**
     * 获取所有菜单
     * @return
     */
    List<SysMenu> getAllMenu();
}
