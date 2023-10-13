package com.multi.deep_dive;

public class ThreadCommEx {

    public static void main(String[] args) {
        Process p = new Process();
        Runnable r1 = () -> {
            try {
                p.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                p.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}

class Process {
    public void produce() throws InterruptedException {

        synchronized (this) { // lock on Process object itself
            System.out.println("Running the producer method. . .");
            wait();
            System.out.println("Again in the producer method. . .");
        }

    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consume method is executed . . .");
            notify();
            System.out.println("Consume method code will run before notification");
            Thread.sleep(1000);
        }

    }
}
