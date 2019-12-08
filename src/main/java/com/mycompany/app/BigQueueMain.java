package com.mycompany.app;

import com.bluejeans.bigqueue.BigQueue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 */
public class BigQueueMain {


    public static void main(String[] args) {
        BigQueue bigQueue = new BigQueue("E:/learn/queueDate", "bigQueue");
        System.out.println("size:"+bigQueue.size());
        byte[] bs = bigQueue.dequeue();
        System.out.println("take one:" + new String(bs));

        System.out.println("size:"+bigQueue.size());
        System.out.println("peek one");
        System.out.println(bigQueue.peek());
        System.out.println("size:"+bigQueue.size());
        //bigQueue.gc();


    }
}
