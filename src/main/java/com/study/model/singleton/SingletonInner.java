package com.study.model.singleton;

/**
 *
 * 使用内部内实现单例模式
 * Created by Administrator on 2017/9/29.
 */
public class SingletonInner {

    private static class MySingleton{
        private  static  SingletonInner  inner = new SingletonInner();
    }

    private  SingletonInner(){
    }

    public static SingletonInner  getInstance(){
       return  SingletonInner.MySingleton.inner;
    }




}
