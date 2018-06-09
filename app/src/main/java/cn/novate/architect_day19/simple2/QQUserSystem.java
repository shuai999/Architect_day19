package cn.novate.architect_day19.simple2;

import java.util.ArrayList;
import java.util.List;
import cn.novate.architect_day19.simple2.handler.AbsUserSystemHandler;
import cn.novate.architect_day19.simple2.handler.UserInfo;


/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/3 11:09
 * Version 1.0
 * Params:
 * Description:    QQ用户系统 - list集合存储 - 不需要暴露list集合，直接暴露一个迭代器iterator()方法给外部即可
*/

public class QQUserSystem extends AbsUserSystemHandler{
    private List<UserInfo> userInfos ;

    public QQUserSystem(){
        userInfos = new ArrayList<>() ;
        userInfos.add(new UserInfo("Novate","123456","001","男")) ;
        userInfos.add(new UserInfo("王子文","123456","002","女")) ;
        userInfos.add(new UserInfo("世道无情","123456","003","男")) ;
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
