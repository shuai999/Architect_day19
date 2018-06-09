package cn.novate.architect_day19.simple2;


import cn.novate.architect_day19.simple2.handler.UserInfo;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/3 11:23
 * Version 1.0
 * Params:
 * Description:    责任链设计模式写法
*/

public class Client {
    public static void main(String[] args){
        // 根据用户名和密码查询用户信息 ，
        // 如果没有查询到，那么代表登录失败；如果查询到了，代表登录成功

        QQUserSystem qqUserSystem = new QQUserSystem() ;
        WXUserSystem wxUserSystem = new WXUserSystem() ;
        NYUserSystem nyUserSystem = new NYUserSystem() ;

        // 责任链设计模式，不断的获取下一个系统，直到最后一个系统为止
        wxUserSystem.nextHandler(qqUserSystem);
        qqUserSystem.nextHandler(nyUserSystem);

        // 如果有数据，就返回；如果没有，就返回null
        UserInfo userInfo = wxUserSystem.queryUserInfo("Novate", "123456");

        // UserInfo{userName='Novate', userPwd='123456', userId='001', userSex='男'}
        System.out.println(userInfo);

    }
}
