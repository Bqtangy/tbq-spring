package com.study.interfaces;

/**
 * 接口隔离原则
 * Created by Administrator on 2017/8/27.
 */
public class TestA {

    public void  dependOne(TestIone  testIone){
        testIone.methodOne();

    }

    public void dependTwo(TestItwo testItwo){
        testItwo.methodTwo();

    }

    public void  dependThree(TestItwo testItwo){
        testItwo.methodThree();
    }
}
