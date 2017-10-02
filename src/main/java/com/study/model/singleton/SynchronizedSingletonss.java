package com.study.model.singleton;
/**
 *
 * 二次性检查安全同步
 * Created by Administrator on 2017/9/28.
 */
public class SynchronizedSingletonss {

    //保持变量的可见性
    private volatile  static  SynchronizedSingletonss  singletonss = null;

    private SynchronizedSingletonss(){

    }
    //双重检查来创建单例
    public static SynchronizedSingletonss  getInstance(){
        try {
            if(singletonss == null){
                synchronized (SynchronizedSingletonss.class){
                    if(singletonss == null){
                        singletonss = new SynchronizedSingletonss();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return singletonss;
    }
}
