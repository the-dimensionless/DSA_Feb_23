package com.multi.deep_dive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// singleton design pattern
enum Downloader {
    INSTANCE;
    private Semaphore semaphore = new Semaphore(3, true);

    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading Data from Web...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SempahoreExample {
    public static void main(String[] args) {
        System.out.println("Sempahore Example=============");
        // create mulitple threads -> use executors

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 12; i++) {
            service.execute(() -> {
                Downloader.INSTANCE.download();
            });
        }
    }
}
