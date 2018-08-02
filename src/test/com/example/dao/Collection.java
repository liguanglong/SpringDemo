package com.example.dao;

import java.util.concurrent.TimeUnit;

/**
 * @author LiGuanglong
 * @date 2018/7/28
 */
public class Collection {

//    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put(null, null);
//        System.out.println(map.keySet());
//        ConcurrentHashMap;
//    }

    public static void main(String[] args) throws InterruptedException {
        waitThread();
        notifyThread();
    }

    private static Object lockObject = new Object();

    private static void waitThread() {
        Thread watiThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObject) {
                    System.out.println(Thread.currentThread().getName() + "wait-before");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        lockObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "after-wait");
                }

            }
        },"waitthread");
        watiThread.start();
    }

    private static void notifyThread() {
        Thread watiThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObject) {
                    System.out.println(Thread.currentThread().getName() + "notify-before");

                    lockObject.notify();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "after-notify");
                }

            }
        },"notifythread");
        watiThread.start();
    }

//waitthreadwait-before
//notifythreadnotify-before
//notifythreadafter-notify
//waitthreadafter-wait
}
