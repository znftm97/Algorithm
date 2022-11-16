package com.company.v2.코드트리.LV4.시뮬레이션;

import java.util.*;
import java.io.*;

public class 기울어진_사각형 {
    private static int maxSum, N = 0;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int wLen = 1; wLen < N; wLen++) {
                    for (int hLen = 1; hLen < N; hLen++) {
                        calSum(r, c, wLen, hLen);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }

    private static void calSum(int r, int c, int wLen, int hLen) {
        int[] dr = {-1, -1, 1, 1};
        int[] dc = {1, -1, -1, 1};
        int[] lens = {wLen, hLen, wLen, hLen};
        int sum = 0;

        for (int dir = 0; dir < 4; dir++) {
            for (int len = 0; len < lens[dir]; len++) {
                r += dr[dir];
                c += dc[dir];

                if (!isAbleArea(r, c)) {
                    return;
                }

                sum += map[r][c];
            }
        }

        maxSum = Math.max(maxSum, sum);
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
