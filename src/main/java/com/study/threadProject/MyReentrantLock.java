package com.study.threadProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁机制  ReentrantLock 锁机制
 * Created by Administrator on 2017/9/30.
 */
public class MyReentrantLock extends Thread {
    private TestReentrantLock lock;
    private int id;


    public MyReentrantLock(int i, TestReentrantLock lock) {
        this.id = i;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.print(id);
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        TestReentrantLock lock = new TestReentrantLock();
        for(int i = 0; i < 10 ; i++){
            service.execute(new MyReentrantLock(i,lock));
        }
        service.shutdown();
    }
}

    class TestReentrantLock{
        private ReentrantLock  lock = new ReentrantLock();
        public void print(int str){
            try {
                lock.lock();
                System.out.println(str+"获得");
                Thread.sleep((int)(Math.random()*1000));
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(str+"释放");
                lock.unlock();
            }
        }
    }

