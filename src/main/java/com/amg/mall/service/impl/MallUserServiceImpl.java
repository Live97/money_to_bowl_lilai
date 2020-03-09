package com.amg.mall.service.impl;

import com.amg.mall.common.Constants;
import com.amg.mall.common.ServiceResultEnum;
import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.dao.I_MallUserDao;
import com.amg.mall.domain.MallUser;
import com.amg.mall.service.I_MallUserService;
import com.amg.mall.util.BeanUtil;
import com.amg.mall.util.MD5Util;
import com.amg.mall.util.ResultGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 商城用户业务层实现类
 */
@Service
public class MallUserServiceImpl implements I_MallUserService {
    
    @Resource
    private I_MallUserDao mallUserDao;
    
    
    /**
     * 商城用户登录方法
     * @param login_name
     * @param login_password
     * @param session
     * @return
     */
    @Override
    public String login(String login_name ,String login_password ,HttpSession session) {
    
        MallUser user = mallUserDao.login(login_name ,login_password);
        
        if (user != null && session != null) {
            
            //代表用户被锁定了，无法登录
            if (user.getLocked_flag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED.getResult();
            }
            
            //昵称太长，影响页面显示
            if (user.getUser_nick_name() != null && user.getUser_nick_name().length() > 7) {
    
                //缩写之后的昵称
                String sub_nickName = user.getUser_nick_name().substring(0 ,7) + "..";
                user.setUser_nick_name(sub_nickName);
            }
            MallUserVO userVO = new MallUserVO();
            BeanUtil.copyProperties(user, userVO);
            session.setAttribute(Constants.Mall_User_SESSION_KEY, userVO);
            return ServiceResultEnum.SUCCESS.getResult();
        }
        //登录失败，返回失败提示信息
        return ServiceResultEnum.LOGIN_FAILED.getResult();
    }
    
    /**
     * 商城用户注册方法
     * @param login_name
     * @param password
     * @return
     */
    @Override
    public String register(String login_name ,String password) {
    
        /**
         * 处理逻辑，如果数据库中存在这个用户名，则返回注册失败，提示已经存在相同用户名
         * 对象不为空即为存在相同的用户名
         */
        if (mallUserDao.findMallUserByLoginName(login_name) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        
        //如果不是则将数据封装进实体类对象中，然后载入数据库
        MallUser registerUser = new MallUser();
        registerUser.setLogin_name(login_name);
        
        //初始化昵称默认是用户名
        registerUser.setUser_nick_name(login_name);
        String passwordMD5 = MD5Util.MD5Encode(password ,"UTF-8");
        registerUser.setLogin_password(passwordMD5);
        
        //调用dao层方法进行载入数据库
        if (mallUserDao.insertMallUser(registerUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return ServiceResultEnum.DB_ERROR.getResult();
        }
        
    }
    
    /**
     * 商城用户修改个人信息业务层实现方法
     * @param mallUser
     * @param session
     * @return
     */
    @Override
    public MallUserVO updateUserInfo(MallUser mallUser ,HttpSession session) {
        
        //根据id查找用户
        MallUser user = mallUserDao.findMallUserById(mallUser.getUser_id());
        System.out.println(user);
        //如果能查出来
        if (user != null) {
            
            //重新赋予修改的值
            user.setUser_nick_name(mallUser.getUser_nick_name());
            user.setIntroduce_sign(mallUser.getIntroduce_sign());
            user.setAddress(mallUser.getAddress());
            
            //判断有没有修改成功
            if (mallUserDao.updateByIdSelective(user) > 0){
                //再查一次，这里再查的用意在于给MallUserVO对象赋值
                user = mallUserDao.findMallUserById(user.getUser_id());
                MallUserVO mallUserVO = new MallUserVO();
                BeanUtils.copyProperties(user, mallUserVO);
                session.setAttribute(Constants.Mall_User_SESSION_KEY, mallUserVO);
                return mallUserVO;
            }
        }
        return null;
    }
}
