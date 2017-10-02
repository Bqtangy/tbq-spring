package com.study.model.singleton;

/**
 * 饿汉式单例
 * Created by Administrator on 2017/9/28.
 */
public class MySingleton {
    private static  MySingleton   mySingleton = new MySingleton();

    private MySingleton(){
    }
    public  static MySingleton  getInstance(){
        return mySingleton;
    }

}
