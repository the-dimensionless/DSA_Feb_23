package com.multi.deep_dive;

public class CounterProblemEx {
    public static int counter = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter is : => "+counter);
    }
}
