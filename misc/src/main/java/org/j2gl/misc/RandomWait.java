package org.j2gl.misc;

public class RandomWait {

    public static void doRandomTimes() throws InterruptedException {
        long startTime = System.currentTimeMillis();        
        double d = Math.random() * 10000;
        long randomWait = Math.abs((long) d);        

        System.out.println("Random Wait: " + randomWait);
        Thread.sleep(randomWait);

        long endTIme = System.currentTimeMillis();
        long diff = endTIme - startTime;

        System.out.println("You waited " + diff + " milliseconds");
        System.out.println("You waited " + diff/1000 + " seconds");

    }

    public static void main(String[] args) throws InterruptedException {
        doRandomTimes();
    }
}