package com.homework9;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();                                     /*mark start time of program*/

        new ValueCalculator().doCalc(1);

        System.out.println("Time in msec: " + (System.currentTimeMillis() - startTime));    /*calc. program time*/
    }
}
