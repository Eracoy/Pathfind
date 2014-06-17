package com.pathfinder;
import java.util.PriorityQueue;

import static com.pathfinder.Direction.*;

public class Pathfinder {
    private int MAPWIDTH = 100;
    private int MAPHEIGHT = 100;
    private double[][] weights;
    private Point[][] points;
    private boolean[][] solved;

    public Pathfinder(int width, int height){
        MAPWIDTH = width;
        MAPHEIGHT = height;
        weights = new double[width][height];
        points = new Point[width][height];
        solved = new boolean[width][height];
        this.setWeights(0); //initialize weights
    }

    //initialize all weights to a set value
    public void setWeights(double weight){
        for(int i=0; i<MAPHEIGHT; i++){
            for(int j=0; j<MAPWIDTH; j++){
                weights[i][j] = weight;
            }
        }
    }


    public void calculateDistances(int xTarget, int yTarget){
        //reset solved flags, directions, and distances
        for(int i=0; i<MAPHEIGHT; i++){
            for(int j=0; j<MAPWIDTH; j++){
                solved[i][j]=false;
                points[i][j].distance=Double.POSITIVE_INFINITY;
            }
        }

        PriorityQueue<Point>
    }

}
