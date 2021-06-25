package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int SizeOfOneArea; // 한 영역에 존재하는 개수 카운팅

    public static void main(String[] args) throws IOException{
        int m = 6;
        int n = 4;
        int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
        //

        int[] answer = new int[2];
        visit = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] > 0 && visit[i][j] == false){
                    SizeOfOneArea = 0;

                    bfs(i, j, picture, m, n);
                    numberOfArea++;

                    if(SizeOfOneArea > maxSizeOfOneArea){
                        maxSizeOfOneArea = SizeOfOneArea;
                    }
                }
            }
        }
        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
    }

    static void bfs(int x, int y, int[][] map, int m, int n){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        visit[x][y] = true;
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty()){
            int curX = qx.poll();
            int curY = qy.poll();
            SizeOfOneArea++;

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < m && ny < n && nx>= 0 && ny >=0){
                    if(map[nx][ny] == map[x][y] && visit[nx][ny] == false){
                        visit[nx][ny] = true;
                        qx.add(nx);
                        qy.add(ny);
                    }
                }
            }
        }

    }
}



