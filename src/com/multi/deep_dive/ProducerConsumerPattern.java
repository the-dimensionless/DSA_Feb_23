package com.multi.deep_dive;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        Processor p = new Processor();
        Runnable r1 = () -> {
            try {
                p.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                p.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}

class Processor {
    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private int value = 0;
    private final Object lock = new Object();

    public void producer() throws InterruptedException {
        synchronized (lock) {

            while(true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items. . .");
                    // wait(); // wait on Class/object lock
                    lock.wait(); // wait on custom lock
                } else {
                    System.out.println("Adding a new item "+ value);
                    list.add(value);
                    value++;
                    // other thread will be notified only if it is in a waiting state
                    // so safe to notify
                    lock.notify();
                }

                Thread.sleep(500);
            }

        }
    }

    public void consumer()  throws InterruptedException {
        synchronized (lock) {
            while(true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("waiting for producer to add values. . .");
                    value = 0;
                    lock.wait();
                } else {
                    System.out.println("Removing element . . ." + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }


}
