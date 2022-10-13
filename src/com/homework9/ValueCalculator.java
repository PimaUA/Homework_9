package com.homework9;

import java.util.Arrays;

public class ValueCalculator implements Runnable {
    private final int arrayLength = 2000000;
    private final int halfArrayLength = arrayLength / 2;
    private float[] array = new float[arrayLength];

    ValueCalculator() {
    }

    ValueCalculator(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < halfArrayLength; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    void doCalc(float el) {
        long startTime = System.currentTimeMillis();                                    /*mark start time of method*/
        float[] destArr1 = new float[halfArrayLength];
        float[] destArr2 = new float[halfArrayLength];
        Arrays.fill(array, el);                                                             /*fill array*/
        System.arraycopy(array, 0, destArr1,
                0, halfArrayLength);                                          /*copy half array to two arrays*/
        System.arraycopy(array, halfArrayLength,
                destArr2, 0, halfArrayLength);
        final Thread thread1 = new Thread(new ValueCalculator(destArr1));                 /*create two threads*/
        final Thread thread2 = new Thread(new ValueCalculator(destArr2));
        thread1.start();
        thread2.start();
        System.arraycopy(destArr1, 0, array, 0, halfArrayLength);        /*merge two arrays into one*/
        System.arraycopy(destArr2, 0, array, halfArrayLength, halfArrayLength);
        System.out.println("Time in msec: " + (System.currentTimeMillis() - startTime)); /*calc. program time*/
    }
}
