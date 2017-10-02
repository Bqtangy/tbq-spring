package com.study.model.singleton;

/**
 * 懒汉模式单例
 * Created by Administrator on 2017/9/28.
 */
public class MySingletonL {

    private static MySingletonL  singleton = null;

    private MySingletonL(){

    }
    public static MySingletonL  getInstance(){
        if(singleton == null){
            singleton = new  MySingletonL();
        }
        return singleton;
    }
}
