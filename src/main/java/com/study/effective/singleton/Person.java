package com.study.effective.singleton;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 提高代码的性能,创建一次对象，提高代码的性能
 * Created by Administrator on 2017/9/3.
 */
public class Person {

    private final Date birthDate;

    private static final Date BOOM_START;

    private static final Date BOOM_END;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    static{
        Calendar  gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        BOOM_START =gmtCal.getTime();

        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END = gmtCal.getTime();

    }



    public boolean  isBabyBoomer(){
        return  birthDate.compareTo(BOOM_START)>=0 && birthDate.compareTo(BOOM_END)< 0;
    }

}
