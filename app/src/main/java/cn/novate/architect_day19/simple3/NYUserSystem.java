package cn.novate.architect_day19.simple3;

import java.util.ArrayList;
import java.util.List;

import cn.novate.architect_day19.simple3.handler.AbsUserSystemHandler;
import cn.novate.architect_day19.simple3.handler.UserInfo;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/9 9:26
 * Version 1.0
 * Params:
 * Description:    农药用户系统
*/

public class NYUserSystem extends AbsUserSystemHandler {

    private List<UserInfo> userInfos;

    public NYUserSystem(){
        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("Novate","123456","001","男"));
        userInfos.add(new UserInfo("王子文","123456","002","女"));
        userInfos.add(new UserInfo("吴京","123456","003","男"));
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
