package com.study.threadProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/9/30.
 */
public class MyExecutor extends Thread {

    private  int index;

    public MyExecutor(int i){
        this.index = i;
    }

    @Override
    public void run(){
        try {
            System.out.println("["+this.index+"] start....");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println("["+this.index+"] end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);
        //开始执行十个线程
        for(int i = 0 ; i < 10; i++){
            service.execute(new MyExecutor(i));
        }
        System.out.println("submit finish");
        service.shutdown();
    }
}
