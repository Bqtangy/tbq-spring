package com.study.effective.staticFactory.impl;

import com.study.effective.staticFactory.Salt;
import com.study.effective.staticFactory.SaltManager;
import com.study.effective.staticFactory.SaltProvider;

/**
 * 海盐厂商提供盐的方式
 * Created by Administrator on 2017/9/2.
 */
public class BaysaltProvider implements SaltProvider {


    /**
     * 去盐监司登记
     */
    static {
        SaltManager.registerProvider("baysaltProvider",new BaysaltProvider());
    }

    public Salt getSalt() {

        //获取盐的方式
        return new Baysalt();
    }
}
