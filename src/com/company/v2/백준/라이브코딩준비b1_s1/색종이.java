package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    private static final int BLACK = 1;
    private static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int blackPaper = Integer.parseInt(br.readLine());

        for (int i = 0; i < blackPaper; i++) {
            st = new StringTokenizer(br.readLine());

            int startC = Integer.parseInt(st.nextToken());
            int startR = Integer.parseInt(st.nextToken());

            paint(startR, startC);
        }

        int result = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (map[i][j] == BLACK) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static void paint(int R, int C) {
        for (int r = R; r < R + 10; r++) {
            for (int c = C; c < C + 10; c++) {
                map[r][c] = BLACK;
            }
        }
    }

}
