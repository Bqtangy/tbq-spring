package com.study.effective.staticFactory.impl;

import com.study.effective.staticFactory.Salt;
import com.study.effective.staticFactory.SaltManager;
import com.study.effective.staticFactory.SaltProvider;

/**
 * Created by Administrator on 2017/9/2.
 */
public class InlandSaltProvider implements SaltProvider {

    //提供盐时先进行注册
    static {
        SaltManager.registerProvider("inlandSaltProvider",new InlandSaltProvider());
    }

    //提供陆
    public Salt getSalt() {
        //用挖掘机挖
        return  new InlandSalt();
    }
}
