package cn.novate.architect_day19.simple2.handler;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/9 9:13
 * Version 1.0
 * Params:
 * Description:    责任链设计模式 - 抽象处理者角色接口
*/

public interface IUserSystemHandler<T extends IUserSystemHandler> {

    /**
     * 获取下一个系统的handler
     */
    void nextHandler(T systemHandler) ;
}
