package com.study.effective;

/**
 * Created by Administrator on 2017/8/27.
 */
public class staticMethod {

    //将boolen 的基本类型转化为Boolen 对象的引用。
    public static  Boolean valueOf(Boolean b){
        return  b ?  Boolean.TRUE : Boolean.FALSE;
    }
}
