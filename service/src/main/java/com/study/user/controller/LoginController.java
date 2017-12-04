package com.study.user.controller;

import com.study.base.BaseController;
import com.study.dto.ResponseVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @创建人 chengyin
 * @创建时间 2017/12/4
 * @描述
 */
@Controller
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * ajax登录请求
     * @param accountName
     * @param password
     * @return
     */
    @PostMapping( value="/login")
    @ResponseBody
    public ResponseVo login(String accountName, String password) {
        ResponseVo responseVo = new ResponseVo();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(accountName, password,false);
        subject.getSession().setAttribute("account", accountName);
        responseVo.setSuccessful(false);
        String msg = "";
        try {
            subject.login(token);
            msg = "登陆成功！";
            logger.info("{}登陆成功!",accountName);
            responseVo.setSuccessful(true);
        } catch(UnknownAccountException e){
            msg = "账户不存在！";
        }catch(IncorrectCredentialsException e){
            msg = "密码错误！";
        }catch (LockedAccountException e) {
            msg = "您的账户已被锁定,请与管理员联系！";
        }catch(ExcessiveAttemptsException e){
            msg = "登录失败次数过多,请稍后再试！";
        }catch(Exception e){
            msg="系统发生错误，请联系管理员！";
        }finally {
            responseVo.setMessage(msg);
            return responseVo;
        }
    }

    /**
     * 退出
     * @return
     */
    @GetMapping(value="/logout")
    @ResponseBody
    public ResponseVo logout(){
        ResponseVo responseVo = new ResponseVo();
        //退出
        SecurityUtils.getSubject().logout();
        responseVo.setMessage("退出账号成功");
        return responseVo;
    }
}
