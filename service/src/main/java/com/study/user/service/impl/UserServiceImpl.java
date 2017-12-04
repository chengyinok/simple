package com.study.user.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.dto.PageDTO;
import com.study.dto.ResponseVo;
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
    public Page<User> selectUserPage(PageDTO pageDTO, User user) {
        Page<User> page = new Page<>(pageDTO.getPage(),pageDTO.getLimit());
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.like("accountName",user.getAccountName());
        page = selectPage(page,entityWrapper);
        return page;
    }

    @Override
    public ResponseVo insertUser(User user) {
        ResponseVo responseVo = new ResponseVo();
        user = md5Password(user,2);
        boolean result = insert(user);
        responseVo.setSuccessful(result);
        return responseVo;
    }

    /**
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中
     * @param user 用户
     * @param hashIterations 迭代次数
     * @return UserEntity对象，包含密文和salt
     */
    public static User md5Password(User user,int hashIterations){
        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
        String salt= secureRandomNumberGenerator.nextBytes().toHex();
        //组合username,两次迭代，对密码进行加密
        String password_cryto = new Md5Hash(user.getPassword(),user.getAccountName()+salt,hashIterations).toString();
        user.setPassword(password_cryto);
        user.setSalt(salt);
        return user;
    }
}
