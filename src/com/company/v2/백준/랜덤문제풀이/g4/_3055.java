package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3055 {
    static char[][] map;
    static int R,C;
    static Dochi end;
    static final char WATER = '*';
    static final char EMPTY = '.';
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static Queue<Water> waterQ = new LinkedList<>();
    static Queue<Dochi> dochiQ = new LinkedList<>();

    static class Dochi implements Comparable<Dochi>{
        int r,c,time;
        public Dochi(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }

        @Override
        public int compareTo(Dochi n) {
            return Integer.compare(this.time, n.time);
        }
    }

    static class Water {
        int r,c;
        public Water(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int r = 0; r<R; r++) {
            String s = br.readLine();
            for(int c = 0; c<C; c++) {
                map[r][c] = s.charAt(c);
                if(map[r][c] == 'D') end = new Dochi(r,c,0);
                else if(map[r][c] == 'S') dochiQ.add(new Dochi(r,c,0));
                else if (map[r][c] == WATER) waterQ.add(new Water(r,c));
            }
        }

        while(true) {
            moveWater();
            moveDochi();
        }
    }

    static void moveWater() {
        Queue<Water> tmpQ = new LinkedList<>(waterQ);
        waterQ.clear();

        while(!tmpQ.isEmpty()) {
            Water now = tmpQ.poll();

            for(int i = 0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(isInArea(nr,nc) && map[nr][nc] == EMPTY) {
                    waterQ.add(new Water(nr,nc));
                    map[nr][nc] = WATER;
                }
            }
        }
    }

    static void moveDochi() {
        if(dochiQ.isEmpty()) {
            System.out.println("KAKTUS");
            System.exit(0);
        }

        Queue<Dochi> tmpQ = new PriorityQueue<>(dochiQ);
        dochiQ.clear();

        while(!tmpQ.isEmpty()) {
            Dochi now = tmpQ.poll();

            if(now.r == end.r && now.c == end.c) {
                System.out.println(now.time);
                System.exit(0);
            }

            for(int i = 0; i<4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(isInArea(nr,nc) && (map[nr][nc] == EMPTY || map[nr][nc] == 'D')) {
                    dochiQ.add(new Dochi(nr,nc, now.time + 1));
                    map[nr][nc] = 'S';
                }
            }
        }
    }

    static boolean isInArea(int r, int c){
        return r>=0 && c>=0 && r<R && c<C;
    }
}
