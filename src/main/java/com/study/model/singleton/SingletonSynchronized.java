package com.study.model.singleton;

/**
 * Created by Administrator on 2017/10/2.
 */
public class SingletonSynchronized {

    private  static  SingletonSynchronized  singleton = new SingletonSynchronized();

    private SingletonSynchronized(){

    }
    public static SingletonSynchronized  getSingleton(){
        return  singleton;
    }

}
