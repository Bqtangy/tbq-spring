package com.study.effective.equals;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 练习equals 的对称性
 * Created by Administrator on 2017/9/10.
 */
public final class CaseInsensitiveString {
    private final  String s;

    public CaseInsensitiveString(String s){
        if(s == null){
            throw new NullPointerException();
        }
        this.s = s;
    }
    @Override
    public boolean equals(Object o){
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);

      /*  if (o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }

        if(o instanceof String ){
            return s.equalsIgnoreCase(((String) o));
        }

        return false;
        */
    }

    public static void main(String[] args) {
        CaseInsensitiveString   cis = new CaseInsensitiveString("Polish");
        String  s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
        list.add(cis);

        System.out.println("包含的对象："+list.contains(s));



        System.out.println("返回值1："+cis.equals(s));

        System.out.println("返回值2 ："+s.equals(cis));//此方法调用String对象的equals 方法。要区分大小写。

    }

}
