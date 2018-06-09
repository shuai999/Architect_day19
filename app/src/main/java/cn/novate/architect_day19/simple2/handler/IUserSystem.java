package cn.novate.architect_day19.simple2.handler;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/9 9:17
 * Version 1.0
 * Params:
 * Description:    校验用户的处理接口
*/

public interface IUserSystem {

    /**
     * 根据用户名和密码查询用户信息
     */
    public UserInfo queryUserInfo(String userName , String userPwd) ;
}
