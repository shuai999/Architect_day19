package cn.novate.architect_day19.simple3.facade;

import java.util.ArrayList;
import java.util.List;

import cn.novate.architect_day19.simple3.NYUserSystem;
import cn.novate.architect_day19.simple3.QQUserSystem;
import cn.novate.architect_day19.simple3.WXUserSystem;
import cn.novate.architect_day19.simple3.handler.AbsUserSystemHandler;
import cn.novate.architect_day19.simple3.handler.IUserSystem;
import cn.novate.architect_day19.simple3.handler.UserInfo;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/9 9:26
 * Version 1.0
 * Params:
 * Description:    门面设计模式 - 易于使用的高层次接口
*/

public class UserSystemFacade implements IUserSystem {

    // 第一个应该检查的系统
    private AbsUserSystemHandler mFirstSystemHandler ;
    /**
     * 把所有子系统都放到门面里边
     */
    public UserSystemFacade(){
        mFirstSystemHandler = new WXUserSystem() ;
        QQUserSystem qqUserSystem = new QQUserSystem() ;
        NYUserSystem nyUserSystem = new NYUserSystem() ;

        // 责任链设计模式，不断的获取下一个系统，直到最后一个系统为止
        mFirstSystemHandler.nextHandler(qqUserSystem);
        qqUserSystem.nextHandler(nyUserSystem);
    }
    @Override
    public UserInfo queryUserInfo(String userName, String userPwd) {
        return mFirstSystemHandler.queryUserInfo(userName , userPwd);
    }
}
