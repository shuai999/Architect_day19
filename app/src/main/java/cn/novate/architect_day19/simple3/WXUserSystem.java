package cn.novate.architect_day19.simple3;


import cn.novate.architect_day19.simple3.handler.AbsUserSystemHandler;
import cn.novate.architect_day19.simple3.handler.UserInfo;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/3 11:10
 * Version 1.0
 * Params:
 * Description:    微信的用户系统 - 数组存储 - 不需要暴露数组，直接暴露一个迭代器iterator()方法给外部即可
*/

public class WXUserSystem extends AbsUserSystemHandler {
    UserInfo[] userInfos ;

    public WXUserSystem(){
        userInfos = new UserInfo[3] ;
        userInfos[0] = new UserInfo("Novate","123456","001","男") ;
        userInfos[1] = new UserInfo("景甜","123456","002","女") ;
        userInfos[2] = new UserInfo("江疏影","123456","003","男") ;
    }


    /**
     * 查询用户信息
     *      首先是自己利用for循环遍历，看是否有userInfo信息：
     *      如果有，就返回；
     *      如果没有，就获取下一个用户系统，让下一个用户系统继续根据用户名和密码查询
     */
    @Override
    public UserInfo queryUserInfo(String userName, String userPwd) {
        for (UserInfo userInfo : userInfos) {
            if (userInfo.userName.equals(userName) && userInfo.userPwd.equals(userPwd)){
                return userInfo ;
            }
        }

        AbsUserSystemHandler nextHandler = getNextHandler();
        if (nextHandler != null) {
            return nextHandler.queryUserInfo(userName, userPwd);
        }

        return null ;
    }
}
