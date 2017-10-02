package com.study.model.singleton;

/**
 * 使用枚举方法创建实例
 * Created by Administrator on 2017/9/29.
 */
public class SingletonClassFactory  {

    private enum  MyEnumSingleton{
        singletonFactory;
        private SynchronizedSingleton  singleton;

        private MyEnumSingleton(){
           singleton = SynchronizedSingleton.getInstance();
        }

        public SynchronizedSingleton  getInstance(){
            return  singleton;
        }
    }
    public static SynchronizedSingleton  getInstance(){
        return   MyEnumSingleton.singletonFactory.getInstance();
    }

}
