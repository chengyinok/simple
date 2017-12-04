package com.study.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.study.redis.RedisUtils;
import com.study.user.entity.User;
import com.study.user.service.UserService;
import com.study.user.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @创建人 chengyin
 * @创建时间 2017/12/4
 * @描述
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //用户登录次数计数  redisKey 前缀
    private String SHIRO_LOGIN_COUNT = "shiro_login_count_";

    //用户登录是否被锁定    一小时 redisKey 前缀
    private String SHIRO_IS_LOCK = "shiro_is_lock_";

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String accountName = token.getUsername();
        String password = String.valueOf(token.getPassword());
        //访问一次，计数一次
        Integer loginCount = (Integer)redisUtils.get(SHIRO_LOGIN_COUNT+accountName);
        if(loginCount == null){
            redisUtils.set(SHIRO_LOGIN_COUNT+accountName,0);
            loginCount = 0;
        }else{
            redisUtils.increment(SHIRO_LOGIN_COUNT+accountName,1);
        }
        //计数大于5时，设置用户被锁定一小时
        if(loginCount>=5){
            redisUtils.set(SHIRO_IS_LOCK+accountName,"LOCK",1, TimeUnit.HOURS);
        }
        if ("LOCK".equals(redisUtils.get(SHIRO_IS_LOCK+accountName))){
            throw new DisabledAccountException("由于密码输入错误次数大于5次，帐号已经禁止登录！");
        }
        User user = new User();
        user.setAccountName(accountName);
        user.setPassword(password);
        //密码进行加密处理  明文为  password+accountName
        user = UserServiceImpl.md5Password(user,2);

        // 从数据库获取对应用户名密码的用户
        List<User> userList = userService.selectList(new EntityWrapper<>(user));
        if(userList.size()!=0){
            user = userList.get(0);
        }else{
            user = null;
        }
        if (null == user) {
            throw new UnknownAccountException("帐号或密码不正确！");
        }else if("0".equals(user.getLocked())){
            /**

             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>

             */
            throw new DisabledAccountException("此帐号已经设置为禁止登录！");
        }else{
            //更新登录时间 last login time

//            user.setLastLoginTime(new Date());
//            sysUserService.updateById(user);
            //清空登录计数
            redisUtils.set(SHIRO_LOGIN_COUNT+accountName, "0");
        }
        logger.info("身份认证成功，登录用户："+accountName);
        return new SimpleAuthenticationInfo(user, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Integer userId = user.getUserId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。

		/*Map<String, Object> map = new HashMap<String, Object>();

		map.put("user_id", userId);

		List<SysRole> roleList = sysRoleService.selectByMap(map);

		Set<String> roleSet = new HashSet<String>();

		for(SysRole role : roleList){

			roleSet.add(role.getType());

		}*/
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。

		/*List<SysPermission> permissionList = sysPermissionService.selectByMap(map);

		Set<String> permissionSet = new HashSet<String>();

		for(SysPermission Permission : permissionList){

			permissionSet.add(Permission.getName());

		}*/
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);
        return info;
    }
}
