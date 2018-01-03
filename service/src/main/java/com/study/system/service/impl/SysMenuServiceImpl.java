package com.study.system.service.impl;

import com.study.system.entity.SysMenu;
import com.study.system.dao.SysMenuDao;
import com.study.system.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chengyin123
 * @since 2018-01-03
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> getAllMenu() {
        return this.baseMapper.getAllMenu();
    }
}
