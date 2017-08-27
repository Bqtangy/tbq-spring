package com.study.interfaces;

/**
 *
 * 接口隔离原则
 * Created by Administrator on 2017/8/27.
 */
public class TestD implements TestIone,TestIthree {
    public void methodOne() {
        System.out.println("one");
    }

    public void methodFour() {
        System.out.println("four");

    }

    public void methodFive() {
        System.out.println("five");

    }
}
