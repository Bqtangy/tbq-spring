package com.study.tomcatCode;

import org.springframework.cglib.core.Local;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/9/26.
 */
public class ResourceBundleMain {

    public static void main(String[] args) {
        System.out.println("default:"+ Locale.getDefault());
        ResourceBundle resourceBundleOne =ResourceBundle.getBundle("myconfig");
        System.out.println(resourceBundleOne.getString("say.hello"));
        System.out.println(resourceBundleOne.getString("say.sorry"));
        System.out.println("===============================");

        Locale  localeOne = new Locale("zh","CN");
        ResourceBundle resourceBundleTwo = ResourceBundle.getBundle("myconfig",localeOne);
        System.out.println(resourceBundleTwo.getString("say.hello"));
        System.out.println(resourceBundleTwo.getString("say.sorry"));
        System.out.println("2==============================");

        Locale localeTwo = new Locale("en", "US");
        ResourceBundle resourceBundleThree = ResourceBundle.getBundle("myconfig",localeTwo);
        System.out.println(resourceBundleThree.getString("say.hello"));
        System.out.println(resourceBundleThree.getString("say.sorry"));


    }
}
