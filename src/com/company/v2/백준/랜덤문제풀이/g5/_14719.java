package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        final int WALL = 1;
        final int EMPTY = 0;

        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < C; c++) {
            int h = Integer.parseInt(st.nextToken());
            int r = R - 1;
            while (h > 0) {
                map[r][c] = WALL;
                h--;
                r--;
            }
        }

        int totalCnt = 0;
        for (int r = R - 1; r >= 0; r--) {
            boolean hasWall = false;
            int cnt = 0;

            for (int c = 0; c < C; c++) {
                if(map[r][c] == WALL) {
                    hasWall = true;
                    totalCnt += cnt;
                    cnt = 0;
                    continue;
                }

                if (hasWall && map[r][c] == EMPTY) cnt++;
            }
        }

        System.out.println(totalCnt);
    }
}
