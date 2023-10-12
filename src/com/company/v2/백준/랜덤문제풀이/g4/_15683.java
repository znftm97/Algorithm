package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15683 {
    static int R, C;
    static final int WALL = 6;
    static int result = Integer.MAX_VALUE;
    static List<Cctv> cctvs = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][][] mode = {
            {{0}},
            {{0}, {1}, {2}, {3}},
            {{1,3}, {0,2}},
            {{0,1}, {1,2}, {2,3}, {3,0}},
            {{0,1,3}, {0,1,2}, {1,2,3}, {0,2,3}},
            {{0,1,2,3}}
    };

    static class Cctv {
        int r,c,type;

        public Cctv(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;
                if(1<=num && num <=5) cctvs.add(new Cctv(r, c, num));
            }
        }

        recursion(0, cctvs.size(), map);
        System.out.println(result);
    }

    static void recursion(int depth, int target, int[][] map) {
        if(depth == target) {
            result = Math.min(result, calculateBlindSpot(map));
            return;
        }

        Cctv cctv = cctvs.get(depth);
        for (int r = 0; r < mode[cctv.type].length; r++) {
            int[][] cMap = copy(map);

            for (int c = 0; c < mode[cctv.type][r].length; c++) {
                int dir = mode[cctv.type][r][c];
                int nr = cctv.r + dr[dir];
                int nc = cctv.c + dc[dir];

                while (isInArea(nr, nc) && cMap[nr][nc] != WALL) {
                    cMap[nr][nc] = -1;
                    nr += dr[dir];
                    nc += dc[dir];
                }
            }

            recursion(depth + 1, target, cMap);
        }
    }

    static int calculateBlindSpot(int[][] map) {
        int blindSpot = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] == 0) blindSpot++;
            }
        }

        return blindSpot;
    }

    static int[][] copy(int[][] map) {
        int[][] cMap = new int[R][C];
        for (int r = 0; r < R; r++) {
            cMap[r] = map[r].clone();
        }

        return cMap;
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
