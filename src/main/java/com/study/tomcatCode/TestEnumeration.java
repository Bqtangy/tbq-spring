package com.study.tomcatCode;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * java 8 新增加的接口
 * Created by Administrator on 2017/9/26.
 */
public class TestEnumeration {

    public static void main(String[] args) {


        Vector v = new Vector();

        v.addElement("lisa");
        v.addElement("billy");
        v.addElement("brown");

        Enumeration elements = v.elements();
        while(elements.hasMoreElements()){
            String value = (String) elements.nextElement();
            System.out.println("获取的值："+value);
        }

    }

   


}
