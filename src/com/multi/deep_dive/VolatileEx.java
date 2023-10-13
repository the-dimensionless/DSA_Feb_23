package com.multi.deep_dive;

public class VolatileEx {
    public static void main(String[] args) {

        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.setTerminated(true);
        System.out.println("Algo is terminated. . . ");

    }
}

class Worker implements Runnable {
    private boolean isTerminated; // CPU may cache this value

    // private volatile boolean isTerminated; // CPU won't cache it, stays in memory

    @Override
    public void run() {
        while(!isTerminated) {
            System.out.println("Worker class is running. . .");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        this.isTerminated = terminated;
    }
}
