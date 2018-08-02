package com.example.dao;

import java.util.concurrent.TimeUnit;

/**
 * @author LiGuanglong
 * @date 2018/8/1
 */
public class TestT {

    public static synchronized void StaticSyncTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("StaticSyncTest");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }

    public synchronized void NonStaticSyncTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("NonStaticSyncTest");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }


    public static void main(String[] args) throws InterruptedException {
        TestT synchronizedTest = new TestT();
        TestT.StaticSyncTest();
        synchronizedTest.NonStaticSyncTest();
    }


}
