package com.study.effective.hashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/10.
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode,int prefix, int lineNumber) throws IllegalAccessException {

       /* rangeCheck(areaCode,999,"area code");
        rangeCheck(prefix,999,"prefix");
        rangeCheck(lineNumber,999,"lineNumber");*/

        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;

    }

    private static void rangeCheck(int arg, int max, String name) throws IllegalAccessException {

        if(arg < 0 || arg > max){
            throw new IllegalAccessException(name+":"+arg);
        }

    }

    @Override
    public boolean equals(Object o){
        if( o == this){
            return true;
        }
        if(!(o instanceof PhoneNumber))
            return false;

        PhoneNumber   pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;

    }

    @Override
    public  int hashCode(){
        int result = 17;
        result = 31*result + areaCode;
        result = 31* result + prefix;
        result = 31* result + lineNumber;
        return result;
    }







    public static void main(String[] args) throws IllegalAccessException {
        Map<PhoneNumber,String> m = new HashMap<PhoneNumber,String>();
        m.put(new PhoneNumber(707,867,5309),"Jenny");

        System.out.println(m.get(new PhoneNumber(707,867,5309)));


    }







}
