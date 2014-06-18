package com.pathfinder;

public class PathfinderDemo {
    public static void main(String[] args){
        for(int size=5; size<500; size+=10) {

            Pathfinder pathfinder = new Pathfinder(size,size);
            long startTime = System.nanoTime();
            pathfinder.calculateDistances(1, 1);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println("Size: "+size+"\tTime: "+duration/1000000+"ms");

        }
        //pathfinder.printDistances();

    }
}
