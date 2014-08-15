package com.pathfinder;
import java.util.PriorityQueue;

import static com.pathfinder.Direction.*;

public class Pathfinder {
    private int MAPWIDTH = 100;
    private int MAPHEIGHT = 100;
    private double[][] weights;
    private double[][] distances;
    private Direction[][] directions;
    private boolean[][] solved;

    private Direction[][] inverseDirections = {{SOUTHEAST, SOUTH, SOUTHWEST},{EAST, NONE, WEST,},{NORTHEAST, NORTH, NORTHWEST}};
    public Pathfinder(int width, int height){
        MAPWIDTH = width;
        MAPHEIGHT = height;
        weights = new double[width][height];
        distances = new double[width][height];
        directions = new Direction[width][height];
        solved = new boolean[width][height];
        this.setWeights(1); //initialize weights
    }

    public double[][] getDistances(){
        return distances;
    }

    public void printDistances(){
        for(double[] row : distances){
            System.out.println(" ");
            for(double point : row){
                if(point==Double.POSITIVE_INFINITY){
                    System.out.print("\t | INF");
                } else {
                    System.out.print("\t | " + Math.floor(point));
                }
            }
        }
        System.out.println("\n");
    }

    //initialize all weights to a set value
    public void setWeights(double weight){
        for(int i=0; i<MAPHEIGHT; i++){
            for(int j=0; j<MAPWIDTH; j++){
                if(i==0 || j==0 || i==MAPHEIGHT-1 || j==MAPWIDTH-1){
                    weights[i][j] = Double.POSITIVE_INFINITY;
                } else {
                    weights[i][j] = weight;
                }
                directions[i][j] = NONE;
            }
        }
    }

    private void updatePointInQueue(PriorityQueue<Point> queue, Point toUpdate, double newWeight){
        queue.remove(toUpdate);
        toUpdate.distance = newWeight;
        queue.add(toUpdate);
    }

    public void updateNeighbors(PriorityQueue<Point> queue, Point p){
        Point dummyPointToRemove = new Point(0,0,0);
        int px = p.x;
        int py = p.y;
        double cWeight = weights[px][py]; //weight of currentPoint
        double alt;

        for(int xOffset=-1; xOffset<=1; xOffset++){
            for(int yOffset=-1; yOffset<=1; yOffset++){
                alt = distances[px][py]+cWeight;
                if(px>1 && py> 1 &&px<MAPWIDTH-2 && py<MAPHEIGHT-2 && !solved[px+xOffset][py+yOffset]) {
                    queue.add(new Point(px + xOffset, py + yOffset, Double.POSITIVE_INFINITY));
                }
                if(alt < distances[px+xOffset][py+yOffset]){
                    distances[px+xOffset][py+yOffset] = alt;
                    directions[px+xOffset][py+yOffset] = inverseDirections[xOffset+1][yOffset+1];
                    dummyPointToRemove.x = px+xOffset;
                    dummyPointToRemove.y = py+yOffset;
                    dummyPointToRemove.distance = distances[px][py];
                    updatePointInQueue(queue, dummyPointToRemove, alt);

                }
            }
        }

    }

    public void calculateDistances(int xTarget, int yTarget){
        double minAlternative;
        PriorityQueue<Point> toSearch = new PriorityQueue<Point>();

        //reset solved flags, directions, and distances
        for(int i=1; i<MAPHEIGHT-1; i++){
            for(int j=1; j<MAPWIDTH-1; j++){
                solved[i][j]=false;
                distances[i][j]=Double.POSITIVE_INFINITY;
                directions[i][j]=NONE;
                //toSearch.add( new Point(i,j,Double.POSITIVE_INFINITY) );
            }
        }
        distances[xTarget][yTarget]=0;

        toSearch.add(new Point(xTarget, yTarget, 0));

        while(!toSearch.isEmpty()){
            //printDistances();
            Point currentPoint = toSearch.poll();
            solved[currentPoint.x][currentPoint.y] = true;

            /*
            for(Point p : toSearch.toArray(new Point[toSearch.size()])){
                System.out.print("/t("+p.x+","+p.y+")");
            } System.out.println("\n");
            */
            updateNeighbors(toSearch, currentPoint);
        }


    }

}
