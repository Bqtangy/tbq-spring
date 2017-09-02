package com.study.effective.staticFactory;

/**
 * Created by Administrator on 2017/9/2.
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

        //陆地盐的提供
        Class.forName("com.study.effective.staticFactory.impl.InlandSaltProvider");

        Salt inlandSalt = SaltManager.getSalt("inlandSaltProvider");

        inlandSalt.addIodine();


    }
}
