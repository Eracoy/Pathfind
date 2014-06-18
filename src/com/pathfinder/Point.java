package com.pathfinder;

//forgive me, father, for I have struct'd
public class Point implements Comparable<Point>{
    public int x;
    public int y;
    public double distance;
    public Point(int x,int y, double distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }

    public int compareTo(Point p){
        if(p.distance<this.distance){
            return 1;
        } else if(p.distance>this.distance){
            return -1;
        } else{
            return 0;
        }
    }
}
