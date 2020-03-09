package com.amg.mall.dao;

import com.amg.mall.domain.MallUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 商城用户dao接口
 */
@Repository
public interface I_MallUserDao {

    /**
     * 商城用户登录接口
     * @param login_name
     * @param login_password
     * @return
     */
    MallUser login(@Param("login_name") String login_name ,@Param("login_password") String login_password);
    
    /**
     * 根据用户名查找商城用户接口
     * @param login_name
     * @return
     */
    MallUser findMallUserByLoginName(String login_name);
    
    
    /**
     * 注册商城用户接口
     * @param registerUser
     * @return
     */
    int insertMallUser(MallUser registerUser);
    
    /**
     * 查询所有的商城用户对象
     * @return
     */
    List<MallUser> findAllMallUser();
    
    /**
     * 根据id查询商城用户
     * @param user_id
     * @return
     */
    MallUser findMallUserById(Integer user_id);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateByIdSelective(MallUser user);
}
