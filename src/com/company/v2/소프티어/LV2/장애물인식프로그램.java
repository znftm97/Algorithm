package com.company.v2.소프티어.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장애물인식프로그램 {
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> blocks = new ArrayList<>();
    private static int block = 0;
    private static int N;

    private static class Point {
        int r,c;

        public Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int r = 0; r<N; r++) {
            String s = br.readLine();
            for(int c = 0; c<N; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        for(int r = 0; r<N; r++) {
            for(int c = 0; c<N; c++) {
                if(map[r][c] == 1 && !visited[r][c]) {
                    bfs(r,c);
                    block++;
                }
            }
        }

        Collections.sort(blocks);

        System.out.println(block);
        for(int block : blocks) {
            System.out.println(block);
        }
    }

    private static void bfs(int startR, int startC) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC));
        visited[startR][startC] = true;

        int cnt = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(isInArea(nr,nc) && isNotVisited(nr, nc) && map[nr][nc] == 1) {
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }

        blocks.add(cnt);
    }

    private static boolean isInArea(int r, int c) {
        return r>=0 && c >=0 && r<N && c<N;
    }

    private static boolean isNotVisited(int r, int c) {
        return !visited[r][c];
    }
}
