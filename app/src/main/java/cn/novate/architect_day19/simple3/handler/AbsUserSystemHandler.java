package cn.novate.architect_day19.simple3.handler;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/6/9 9:11
 * Version 1.0
 * Params:
 * Description:    责任链设计模式 - 抽象处理者角色
*/

public abstract class AbsUserSystemHandler implements IUserSystemHandler<AbsUserSystemHandler>, IUserSystem {

    private AbsUserSystemHandler nextHandler ;

    /**
     * 获取下一个系统
     */
    public AbsUserSystemHandler getNextHandler() {
        return nextHandler;
    }


    /**
     * 如果微信用户系统没有查到信息，就设置下一个系统，是qq用户系统
     * 如果qq用户系统没有查到信息，就设置下一个系统，是农药用户系统
     * 如果还有下一个用户系统，会去设置下一个系统...
     */
    public void nextHandler(AbsUserSystemHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
