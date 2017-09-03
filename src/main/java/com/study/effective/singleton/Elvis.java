package com.study.effective.singleton;

/**
 * 创建单例
 * Created by Administrator on 2017/9/3.
 */
public class Elvis {

    private static final Elvis  instance = new Elvis();

    private Elvis(){

    }

    public  static Elvis getInstance(){
        return  instance;
    }

    public void leaveTheBuilding(){

    }



}
