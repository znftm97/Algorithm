package com.company.v2.백준.기타_랜덤디펜스.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임_3085 {
    private static char[][] map;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxCandyCount = 0;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 가로 교환
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N - 1; c++) {
                maxCandyCount = Math.max(maxCandyCount, getCandyCountVertical(c)); // swap하기 전에 검사

                swap(r, c, r, c + 1);
                maxCandyCount = Math.max(maxCandyCount, getCandyCountVertical(c));
                maxCandyCount = Math.max(maxCandyCount, getCandyCountVertical(c + 1));
                maxCandyCount = Math.max(maxCandyCount, getCandyCountWidth(r));

                // 최대값 나오면 더이상 검사할 필요 없음
                if (maxCandyCount == N) {
                    System.out.println(N);
                    return;
                }

                swap(r, c, r, c + 1); // 원래대로 복구
            }
        }

        // 세로 교환
        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < N; c++) {
                maxCandyCount = Math.max(maxCandyCount, getCandyCountWidth(r)); // swap하기 전에 검사

                swap(r, c, r + 1, c);
                maxCandyCount = Math.max(maxCandyCount, getCandyCountWidth(r));
                maxCandyCount = Math.max(maxCandyCount, getCandyCountWidth(r + 1));
                maxCandyCount = Math.max(maxCandyCount, getCandyCountVertical(c));

                // 최대값 나오면 더이상 검사할 필요 없음
                if (maxCandyCount == N) {
                    System.out.println(N);
                    return;
                }

                swap(r, c, r + 1, c); // 원래대로 복구
            }
        }

        System.out.println(maxCandyCount);
    }

    private static void swap(int r1, int c1, int r2, int c2) {
        char c = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = c;
    }

    private static int getCandyCountVertical(int c) {
        char beforeChar = map[0][c];
        int count = 1;
        int maxCount = 0;

        for (int i2 = 1; i2 < N; i2++) {
            char nextChar = map[i2][c];

            if(beforeChar == nextChar) {
                count++;
            } else {
                beforeChar = nextChar;
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        return Math.max(maxCount, count);
    }

    private static int getCandyCountWidth(int r) {
        char beforeChar = map[r][0];
        int count = 1;
        int maxCount = 0;

        for (int j2 = 1; j2 < N; j2++) {
            char nextChar = map[r][j2];

            if(beforeChar == nextChar) {
                count++;
            } else {
                beforeChar = nextChar;
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        return Math.max(maxCount, count);
    }

}
