package com.study;

import com.study.system.dao.SysMenuDao;
import com.study.system.entity.SysMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description:
 * User: chengyin
 * Date: 2018-01-03
 * Time: 15:38
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuDaoTest {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Test
    public void getAllMenu() throws Exception {
        List<SysMenu> sysMenuList = sysMenuDao.getAllMenu();
        for(SysMenu sysMenu :sysMenuList){
            System.out.println(sysMenu.toString());
            System.out.println("111111111111111111111111111111111111");
        }
    }

}