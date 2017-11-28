package com.study.user.service.impl;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.study.user.entity.User;
import com.study.user.dao.UserDao;
import com.study.user.service.UserService;

/**
 * <p>
 * 用户账户表 服务实现类
 * </p>
 *
 * @author chengyin
 * @since 2017-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
