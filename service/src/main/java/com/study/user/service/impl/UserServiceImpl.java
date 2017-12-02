package com.study.user.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
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

    @Override
    public Page<User> selectUserPage() {
        Page<User> page = new Page<>(0,10);
        page = selectPage(page);
        return page;
    }

    /**
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中
     * @param username 用户名
     * @param password 密码
     * @param hashIterations 迭代次数
     * @return UserEntity对象，包含密文和salt
     */
    public static User md5Password(String username,String password,int hashIterations){
        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
        String salt= secureRandomNumberGenerator.nextBytes().toHex();
        //组合username,两次迭代，对密码进行加密
        String password_cryto = new Md5Hash(password,username+salt,hashIterations).toString();
        User user=new User();
        user.setPassword(password_cryto);
        user.setSalt(salt);
        user.setAccountName(username);
        return user;
    }
}
