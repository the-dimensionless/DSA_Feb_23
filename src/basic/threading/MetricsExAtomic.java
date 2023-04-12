package basic.threading;

import java.util.Random;

public class MetricsExAtomic {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        BusinessLogix b1 = new BusinessLogix(metrics);
        BusinessLogix b2 = new BusinessLogix(metrics);
        MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);

        b1.start();
        b2.start();
        metricsPrinter.start();
    }

    public static class MetricsPrinter extends Thread {
        private Metrics metrics;

        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }

        public void run() {
            while(true) {
                System.out.println("Average: " + metrics.getAverage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class BusinessLogix extends Thread {
        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogix(Metrics metrics) {
            this.metrics = metrics;
        }

        public void run() {
            while (true) {
                long start = System.currentTimeMillis();

                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException ex) {

                }
                long end = System.currentTimeMillis();

                metrics.addSample(end - start);
            }
        }
    }

    public static class Metrics {
        private long count = 0;
        private volatile double average = 0.0;

        public synchronized void addSample(long sample) {
            double currentSum = average * count;
            count++;
            average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return average;
        }
    }
}
