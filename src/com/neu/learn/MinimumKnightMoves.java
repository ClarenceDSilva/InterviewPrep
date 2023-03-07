package com.neu.learn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Leetcode: 1197
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
then one square in an orthogonal direction.

Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.
* */
public class MinimumKnightMoves {

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public final int[][] knightMove = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public int minKnightMoves(int x, int y) {
        //Optimization for runtime also on Line 56
        x = Math.abs(x);
        y = Math.abs(y);

        int moves = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0,0));
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        // BFS
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Coordinate currPos = queue.remove();
                if(currPos.x == x && currPos.y == y) {
                    //If the curr pos is the target pos then return
                    return moves;
                }
                for(int j = 0; j < knightMove.length; j++) {
                    int xDir = currPos.x + knightMove[j][0];
                    int yDir = currPos.y + knightMove[j][1];

                    //Forming a string for the visited set
                    String s = xDir + "," + yDir;
                    if(!visited.contains(s) && xDir >=-2 && yDir >= -2) {
                        queue.add(new Coordinate(xDir, yDir));
                        visited.add(s);
                    }

                }
            }
            ++moves;
        }
        return -1;
    }
}
