package com.amg.mall.controller.mall;

import com.amg.mall.common.Constants;
import com.amg.mall.common.ServiceResultEnum;
import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.domain.MallUser;
import com.amg.mall.service.I_MallUserService;
import com.amg.mall.util.MD5Util;
import com.amg.mall.util.Result;
import com.amg.mall.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 商城用户控制器,与用户进行操作的
 */
@Controller
public class MallUserController {


    @Autowired
    private I_MallUserService mallUserService;
    /**
     * 登录页面
     * @return
     */
    @GetMapping({"/login","login.jsp"})
    public String loginPage() {
        return "mall/login";
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping({"/register","register.jsp"})
    public String registerPage(){
        return "mall/register";
    }
    
    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logoutPage(HttpSession session){
        session.removeAttribute(Constants.Mall_User_SESSION_KEY);
        return "mall/index";
    }
    
    /**
     * 用户个人中心
     * @param session
     * @return
     */
    @GetMapping("/personal")
    public String personalPage(HttpSession session){
    
        session.setAttribute("path", "personal");
        return "mall/self_info";
    }
    
    
    /**
     *
     * post请求的login页面，用于登录
     * 定义@ResponseBody注解在于可以将方法的返回值转换为json字符串响应回到前台中
     * @param login_name
     * @param login_password
     * @param verifyCode
     * @param session
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public  Result login(@RequestParam("username") String login_name,
                        @RequestParam("password") String login_password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session
                        ) {
    
        if (StringUtils.isEmpty(login_name)) {
            /**
             * 如果用户名为空,调用Result生成器，里面传一个message，message的获取通过ServiceResultEnum枚举出来
             */
            Result result = ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_NAME_NULL.getResult());
            return result;
        }
        if (StringUtils.isEmpty(login_password)) {
            /**
             * 如果密码为空 ...
             */
            Result result = ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_PASSWORD_NULL.getResult());
            return result;
        }
        //通过session对象获取验证码，在其他地方传入验证码
//        Object session_verifyCode = session.getAttribute("session_verifyCode");
//        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(session_verifyCode)) {
//
//            /**
//             * 当验证码为空或者验证码不匹配时
//             */
//            Result result = ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_ERROR.getResult());
//            return result;
//        }
    
        //获取登录状态返回信息
        String loginResult = mallUserService.login(login_name ,MD5Util.MD5Encode(login_password, "UTF-8") ,session);
        //登录成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(loginResult)) {
            
            return ResultGenerator.getSuccessResult();
        }
        //登录失败
        return ResultGenerator.getFailResult(loginResult);
        
    }
    
    /**
     * post请求的注册页面，用于注册商城用户
     * @param username
     * @param password
     * @param repassword
     * @param verifyCode
     * @param session
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public  Result register(@RequestParam("username")   String username,
                           @RequestParam("password")   String password,
                           @RequestParam("repassword") String repassword,
                           @RequestParam("verifyCode") String verifyCode,
                           HttpSession session
                           ) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("repassword = " + repassword);
        //判断是否为空
        if (StringUtils.isEmpty(username)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_NAME_NULL.getResult());
        }
        if (StringUtils.isEmpty(password)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_PASSWORD_NULL.getResult());
        }
        if (StringUtils.isEmpty(repassword)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_REPASSWORD_NULL.getResult());
        }
        
        //判断两次输入的密码是否一致
        if (!password.equals(repassword)) {
            return ResultGenerator.getFailResult(ServiceResultEnum.TWICE_PASSWORD_NOEQUALS.getResult());
        }
        
        //获取验证码
//        Object session_verifyCode = session.getAttribute("verifyCode");
//        if (StringUtils.isEmpty(verifyCode) || !verifyCode.equals(session_verifyCode)) {
//            return ResultGenerator.getFailResult(ServiceResultEnum.LOGIN_VERIFY_CODE_ERROR.getResult());
//        }
        
        String registerResult = mallUserService.register(username,password);
        if (ServiceResultEnum.SUCCESS.getResult().equals(registerResult)) {
            
            //说明注册成功,返回注册成功的状态和信息
            return ResultGenerator.getSuccessResult();
        }
        //不然就是注册失败...
        return ResultGenerator.getFailResult(registerResult);
    }
    
    
    
    @PostMapping("/personal/updateInfo")
    @ResponseBody
    public Result updateMallUserInfo(@RequestBody MallUser mallUser,HttpSession session){
    
        System.out.println(mallUser);
        MallUserVO mallUserVOtemp = mallUserService.updateUserInfo(mallUser,session);
        
        
        if (mallUserVOtemp == null) {
            //如果对象为空，代表是修改失败，直接返回信息即可
            return ResultGenerator.getFailResult("修改失败！");
        }
        
        //修改成功！
        return ResultGenerator.getSuccessResult();
    }

}
