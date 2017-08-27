package com.study.interfaces;

/**
 *
 * 接口隔离原则
 * Created by Administrator on 2017/8/27.
 */
public class TestB implements TestIone, TestItwo {
    public void methodOne() {
        System.out.println("one");
    }

    public void methodTwo() {
        System.out.println("two");

    }

    public void methodThree() {
        System.out.println("three");

    }
}
