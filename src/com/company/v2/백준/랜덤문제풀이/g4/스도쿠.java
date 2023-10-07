package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스도쿠 {
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] colums = new boolean[9][10];
    static boolean[][] map33 = new boolean[9][10];
    static int[][] map = new int[9][9];
    static final int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < N; c++) {
                int num = s.charAt(c) - '0';
                map[r][c] = num;
                rows[r][num] = true;
                colums[c][num] = true;
                map33[3 * (r / 3) + (c / 3)][num] = true;
            }
        }

        sdoku(0);
    }

    static void sdoku(int idx) {
        if(idx >= 81) {
            print();
        }

        int r = idx / 9;
        int c = idx % 9;
        if (map[r][c] != 0) {
            sdoku(idx + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if(canVisit(r,c,i)) {
                    rows[r][i] = true;
                    colums[c][i] = true;
                    map33[3*(r/3)+c/3][i] = true;
                    map[r][c] = i;

                    sdoku(idx + 1);

                    rows[r][i] = false;
                    colums[c][i] = false;
                    map33[3*(r/3)+c/3][i] = false;
                    map[r][c] = 0;
                }
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        System.exit(0);
    }

    static boolean canVisit(int r, int c, int i) {
        return !rows[r][i] && !colums[c][i] && !map33[3*(r/3)+c/3][i];
    }
}
