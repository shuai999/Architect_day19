package cn.novate.architect_day19.simple3;


import cn.novate.architect_day19.simple3.facade.UserSystemFacade;
import cn.novate.architect_day19.simple3.handler.UserInfo;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/3 11:23
 * Version 1.0
 * Params:
 * Description:    门面设计模式写法
*/

public class Client {
    public static void main(String[] args){
        // 根据用户名和密码查询用户信息 ，
        // 如果没有查询到，那么代表登录失败；如果查询到了，代表登录成功


        // 门面设计模式
        UserSystemFacade userSystemFacade = new UserSystemFacade() ;

        // 如果有数据，就返回；如果没有，就返回null
        UserInfo userInfo = userSystemFacade.queryUserInfo("Novate", "123456");

        // UserInfo{userName='Novate', userPwd='123456', userId='001', userSex='男'}
        System.out.println(userInfo);

    }
}
