package com.example.demo.task;

public class ThreadDeadLock {

    private static final Object obj1 = "obj1";
    private static final Object obj2 = "obj2";

    public static void main(String[] args) {
        ThreadDeadLock td = new ThreadDeadLock();
        td.deadLock();
        //td.deadLockFix();
    }

    public void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (obj1) {
                try {
                    System.out.println("deadLock | obj1 locked: " + Thread.currentThread().getName());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj2) {
                    System.out.println("deadLock | obj2 locked: " + Thread.currentThread().getName());
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj2) {
                try {
                    System.out.println("deadLock | obj2 locked: " + Thread.currentThread().getName());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj1) {
                    System.out.println("deadLock | obj1 locked: " + Thread.currentThread().getName());
                }
            }
        });
        t1.start();
        t2.start();
    }

    public void deadLockFix() {
        Thread t1 = new Thread(() -> {
            synchronized (obj1) {
                try {
                    System.out.println("deadLockFix | obj1 locked: " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj2) {
                    System.out.println("deadLockFix | obj2 locked: " + Thread.currentThread().getName());
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (obj1) {
                try {
                    System.out.println("deadLockFix | obj1 locked: " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj2) {
                    System.out.println("deadLockFix | obj2 locked: " + Thread.currentThread().getName());
                }
            }
        });
        t1.start();
        t2.start();
    }
}
