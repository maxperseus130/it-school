package com.itschool.challange.curs5ppt.maze;

/*
Challenge
13. Pathfinding in a Maze
Consider a simple maze represented by a 2D grid. The maze consists of
open cells, walls, a start, and an end. You have to find a path from the
start to the end, moving only up, down, left, or right. You can't move
diagonally. If a path exists, print it; otherwise, inform the user that
there's no solution.

The maze will be represented by a 2D array where:
0 represents an open cell.
1 represents a wall.
S represents the start.
E represents the end.

        Example:
        S 1 0 1
        0 1 0 1
        0 1 0 1
        1 0 0 E

Problem Tasks:
Read the maze layout from a file or hard-code it into your program.
Implement a pathfinding algorithm to navigate from the start to the end.
If a path is found, print the maze with the path. You can represent the
path with a *.
If no path exists, print "No solution found."
*/

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Maze {

    public static int[][] start(StringBuilder[] maze, int mlen) {
        boolean found = false;
        int[][] coord = new int[2][2];
        int i = 0;

        while (i < mlen) {
            if(maze[i].indexOf("S") != -1) {
                coord[0][0] = i;
                coord[0][1] = maze[i].indexOf("S");
                found = true;
                break;
            }
            i++;
        }

        int sIdx = coord[0][1];

        if(coord[0][0] != 0 && maze[i - 1].charAt(sIdx) == '0') {
            coord[1][0] = i - 1;
            coord[1][1] = maze[i].indexOf("S");
        }
        if(coord[0][0] != mlen - 1 && maze[i + 1].charAt(sIdx) == '0') {
            coord[1][0] = i + 1;
            coord[1][1] = maze[i].indexOf("S");
        }
        if(coord[0][1] != 0 && maze[i].charAt(sIdx - 1) == '0') {
            coord[1][0] = i;
            coord[1][1] = maze[i].indexOf("S") - 1;
        }
        if(coord[0][1] != maze[i].length() - 1 && maze[i].charAt(sIdx + 1) == '0') {
            coord[1][0] = i;
            coord[1][1] = maze[i].indexOf("S") + 1;
        }

        if(found) {
            return coord;
        }

        coord[0][0] = -1;
        coord[0][1] = -1;
        coord[1][0] = -1;
        coord[1][1] = -1;

        return coord;
    }

    public static int[][] path(StringBuilder[] maze, int[][] pth, int idx, int i, int j) {
        int k = 0;
        while (k < idx) {
            if(pth[k][0] == i && pth[k][1] == j) {
                pth[idx][0] = -1;
                pth[idx][1] = -1;
                return pth;
            }
            k++;
        }

        pth[idx][0] = i;
        pth[idx][1] = j;
        return pth;
    }

    public static StringBuilder[] makePath(StringBuilder[] maze, int[][] pth, int mlen, int pIdx,
                            int preI, int preJ, int nowI, int nowJ) {

        if (maze[nowI].charAt(nowJ) == 'E'){
            for (int i = 0; i < pIdx; i++) {
                maze[pth[i][0]].setCharAt(pth[i][1], '*');
            }
            return maze;
        }
        if (maze[nowI].charAt(nowJ) == 'S')
            return null;

        int[][] nPth = new int[100][2];

        for (int i = 0; i < pIdx; i++) {
            nPth[i][0] = pth[i][0];
            nPth[i][1] = pth[i][1];
        }

        path(maze, nPth, pIdx, nowI, nowJ);

        if(nPth[pIdx][0] == -1){
            return null;
        } else {
            pIdx++;
        }

        char up, down, left, right;

        if(nowI != 0 && nowI - 1 != preI) {
            up = maze[nowI - 1].charAt(nowJ);
        } else {
            up = 'N';
        }
        if(nowI != mlen - 1 && nowI + 1 != preI) {
            down = maze[nowI + 1].charAt(nowJ);
        } else {
            down = 'N';
        }
        if(nowJ != 0 && nowJ - 1 != preJ) {
            left = maze[nowI].charAt(nowJ - 1);
        } else {
            left = 'N';
        }
        if(nowJ != maze[nowI].length() - 1 && nowJ + 1 != preJ) {
            right = maze[nowI].charAt(nowJ + 1);
        } else {
            right = 'N';
        }

        if(up != 'N' && up != '1') {
            StringBuilder[] solution = makePath(maze, nPth, mlen, pIdx, nowI, nowJ, nowI - 1, nowJ);
            if (solution != null) {
                return solution;
            }
        }
        if(down != 'N' && down != '1') {
            StringBuilder[] solution = makePath(maze, nPth, mlen, pIdx, nowI, nowJ, nowI + 1, nowJ);
            if (solution != null) {
                return solution;
            }
        }
        if(left != 'N' && left != '1') {
            StringBuilder[] solution = makePath(maze, nPth, mlen, pIdx, nowI, nowJ, nowI, nowJ - 1);
            if (solution != null) {
                return solution;
            }
        }
        if(right != 'N' && right != '1') {
            return makePath(maze, nPth, mlen, pIdx, nowI, nowJ, nowI, nowJ + 1);
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("C:\\Users\\Maxperseus130\\Desktop\\it-school" +
                "\\src\\com\\itschool\\challange\\curs5ppt\\maze\\Maze");

        Scanner sc = new Scanner(fileName);
        StringBuilder[] maze = new StringBuilder[100];
        int i = 0;
        while(sc.hasNext()) {
            maze[i] = new StringBuilder(sc.next());
            i++;
        }
        sc.close();

        int[][] begin = start(maze, i);
        if (begin[0][0] == -1)
            System.out.println("Start not found.");

        int[][] path = new int[100][2];

        maze = makePath(maze, path, i, 0, begin[0][0], begin[0][1], begin[1][0], begin[1][1]);

        if (maze != null)
            for (int j = 0; j < i; j++)
                System.out.println(maze[j]);
        else
            System.out.println("There is no path.");
    }
}
