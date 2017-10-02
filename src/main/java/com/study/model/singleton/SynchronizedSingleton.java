package com.study.model.singleton;

/**
 *
 * 线程安全的单例模式
 * Created by Administrator on 2017/9/28.
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton  singleton = null;

    private SynchronizedSingleton(){

    }
    public static SynchronizedSingleton getInstance(){
        try {
            //这样同步代码块效率比较低
            synchronized (SynchronizedSingleton.class){
                if(singleton == null){
                    Thread.sleep(300);
                    singleton = new SynchronizedSingleton();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  singleton;
    }



}
