package com.study.effective.equals;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/9/10.
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();//integer 类型的原子性

    public CounterPoint(int x,int y){
        super(x,y);
        counter.incrementAndGet();
    }

    public int numberCreated(){
        return counter.get();
    }



}
