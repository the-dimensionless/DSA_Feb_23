package basic.threading;

public class SyncEx {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter ic = new InventoryCounter();

        IncrementingThread inc = new IncrementingThread(ic);
        DecrementingThread dec = new DecrementingThread(ic);

        inc.start();
        dec.start();

        inc.join();
        dec.join();

        System.out.println("We currently have " + ic.getItems() + " items");

    }

    public static class DecrementingThread extends Thread {
        private InventoryCounter ic;

        public DecrementingThread(InventoryCounter ic) {
            this.ic = ic;
        }

        public void run() {
            for (int i = 0; i < 10000; i++) {
                ic.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {
        private InventoryCounter ic;

        public IncrementingThread(InventoryCounter ic) {
            this.ic = ic;
        }

        public void run() {
            for (int i = 0; i < 10000; i++) {
                ic.increment();
            }
        }
    }

    private static class InventoryCounter {
        private int items = 0;

        public synchronized void increment() {
            items++;
        }

        public synchronized void decrement() {
            items--;
        }

        public synchronized int getItems() {
            return items;
        }
    }
}


