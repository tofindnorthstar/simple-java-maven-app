package com.mycompany.app;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}
    public final static Set<Integer> set = new HashSet<Integer>(){
        {
            add(1);
            add(2);
        }
    };


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        System.out.println(semaphore.availablePermits());
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                if (semaphore.tryAcquire()) {
                    System.out.println("get permit");
                    try {
                        Thread.sleep(10 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(11);

                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("t2  is sleep");
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("try to get permit");
                if (semaphore.availablePermits() == 1) {
                    System.out.println(22);
                }else{
                    System.out.println("no permit");
                }
            }
        });
        t1.start();
        t2.start();

    }

    private final String getMessage() {
        /*
        * test
        * */
        return message;
    }

}
