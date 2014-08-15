package com.pathfinder;

public class PathfinderDemo {
    public static void main(String[] args){
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(true)
        for(int size=10; size<300; size=size+size/4) {

            Pathfinder pathfinder = new Pathfinder(size,size);
            long startTime = System.nanoTime();
            pathfinder.calculateDistances(5, 5);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println("Size: "+size+"\tTime: "+duration/1000000+"ms");

        }
        /*
        Pathfinder pathfinder = new Pathfinder(30,30);
        long startTime = System.nanoTime();
        pathfinder.calculateDistances(5, 5);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Size: "+30+"\tTime: "+duration/1000000+"ms");
        pathfinder.printDistances();
*/
    }
}
