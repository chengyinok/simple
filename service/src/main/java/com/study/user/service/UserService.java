package com.study.user.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.study.dto.PageDTO;
import com.study.dto.ResponseVo;
import com.study.user.entity.User;

/**
 * <p>
 * 用户账户表 服务类
 * </p>
 *
 * @author chengyin
 * @since 2017-11-28
 */
public interface UserService extends IService<User> {

    /**
     * 用户信息分页查询
     * @param pageDTO
     * @param user
     * @return
     */
    Page<User> selectUserPage(PageDTO pageDTO, User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    ResponseVo insertUser(User user);
}
