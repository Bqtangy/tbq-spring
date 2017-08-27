package com.study.interfaces;

/**
 *
 * 接口隔离原则
 * Created by Administrator on 2017/8/27.
 */
public class TestC {
    public void dependOne(TestIone testIone){
        testIone.methodOne();
    }

    public void dependFoure(TestIthree testIthree){
        testIthree.methodFour();
    }

    public void dependFive(TestIthree testIthree){
        testIthree.methodFive();
    }

}
