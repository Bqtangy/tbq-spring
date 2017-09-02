package com.study.effective.staticFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 盐的登记
 * Created by Administrator on 2017/9/2.
 */
public class SaltManager {

    //食盐生产商登记档案
    public static final Map<String, SaltProvider> providers = new ConcurrentHashMap<String, SaltProvider>();

    //食盐厂商进行登记
    public static void registerProvider(String name, SaltProvider provider) {
        providers.put(name, provider);
    }

    //获取食盐
    public static Salt getSalt(String name) {
        SaltProvider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException(
                    "No SaltProvider registered with name:" + name);
        }
       return p.getSalt();
    }
}




