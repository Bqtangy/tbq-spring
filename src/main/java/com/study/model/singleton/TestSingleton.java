package com.study.model.singleton;

/**
 *
 * 测试单例模式
 * Created by Administrator on 2017/9/29.
 */
public class TestSingleton extends  Thread{

    @Override
    public void run(){
        System.out.println("进行测试这个单例模式！"+SingletonSynchronized.getSingleton().hashCode());
    }
    public static void main(String[] args) {
        TestSingleton[]  threads = new TestSingleton[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new TestSingleton();
        }

        for (int j = 0; j < threads.length; j++){
            threads[j].start();
        }

    }






}
