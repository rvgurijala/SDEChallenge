package com.paytm.statistics;

public class App {

    public static void main(String[] args) {

        System.out.println("-----------------MovingAverageImpl---------------\n\n");

        IMovingAverage<Double> ma = new MovingAverageImpl(5);

        ma.addValue(4.0);
        ma.addValue(6.0);
        ma.addValue(5.0);
        ma.addValue(10.0);
        ma.addValue(11.0);
        ma.addValue(3.0);
        System.out.println("Elements: " + ma.getAllElements());
        System.out.println("Average: " + ma.getAverage());

        ma.reset();
        ma.addValue(15.0);
        ma.addValue(9.0);
        System.out.println("Elements: " + ma.getAllElements());
        System.out.println("Average: " + ma.getAverage());


        System.out.println("\n\n-----------------SynchronizedMovingAverageImpl---------------\n\n");

        IMovingAverage<Double> sma = new SynchronizedMovingAverageImpl(5);

        Thread t1 = new Thread(() -> {
            sma.addValue(1.0);
            System.out.println("Elements: " + sma.getAllElements());
            System.out.println(sma.getAverage());

            sma.addValue(2.0);
            System.out.println("Elements: " + sma.getAllElements());
            System.out.println(sma.getAverage());

            sma.addValue(6.0);
            System.out.println("Elements: " + sma.getAllElements());
            System.out.println(sma.getAverage());
        });

        Thread t2 = new Thread(() -> {
            sma.addValue(10.0);
            System.out.println("Elements: " + sma.getAllElements());
            System.out.println(sma.getAverage());

            sma.addValue(12.0);
            System.out.println("Elements: " + sma.getAllElements());
            System.out.println(sma.getAverage());

            sma.addValue(4.0);
            System.out.println("Elements: " + sma.getAllElements());
            System.out.println(sma.getAverage());
        });


        t1.start();
        t2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
