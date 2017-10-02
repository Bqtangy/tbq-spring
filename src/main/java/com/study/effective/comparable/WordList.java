package com.study.effective.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 比较器的方法
 * Created by Administrator on 2017/9/10.
 */
public class WordList {

    public static void main(String[] args) {
        Set<String>  s = new TreeSet<String>();
        Collections.addAll(s,args);
        System.out.println(s);
    }
}
