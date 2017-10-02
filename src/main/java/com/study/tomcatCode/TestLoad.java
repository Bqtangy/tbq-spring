package com.study.tomcatCode;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/9/26.
 */
public class TestLoad {

    public static void main(String[] args) {

        try {

            InputStream  is = TestLoad.class.getResourceAsStream("myProps.properties");
            Properties  p = new Properties();
            p.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
