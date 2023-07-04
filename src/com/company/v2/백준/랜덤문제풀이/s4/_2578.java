package com.company.v2.백준.랜덤문제풀이.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2578 {
    private static int[][] map = new int[5][5];
    private static boolean[][] checks = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                int num = Integer.parseInt(st.nextToken());
                check(num);
                cnt++;
                if(cnt > 11 && isBingo()) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    private static void check(int num) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if(map[r][c] == num) {
                    checks[r][c] = true;
                    return;
                }
            }
        }
    }

    private static boolean isBingo() {
        int bingo = 0;

        for (int r = 0; r < 5; r++) {
            int cnt = 0;
            for (int c = 0; c < 5; c++) {
                if(checks[r][c]) cnt++;
            }

            if(cnt == 5) bingo++;
        }

        for (int c = 0; c < 5; c++) {
            int cnt = 0;
            for (int r = 0; r < 5; r++) {
                if(checks[r][c]) cnt++;
            }

            if(cnt == 5) bingo++;
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if(checks[i][i]) cnt++;
        }
        if(cnt == 5) bingo++;

        cnt = 0;
        int r = 0;
        int c = 4;
        for (int i = 0; i < 5; i++) {
            if(checks[r++][c--]) cnt++;
        }
        if(cnt == 5) bingo++;

        return bingo >= 3;
    }
}
