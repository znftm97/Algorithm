package com.company.v2.코드트리.LV4.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수사각형_최댓값의_최소 {
    private static int N;
    private static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initialize();

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                dp[r][c] = Math.max(Math.min(dp[r - 1][c], dp[r][c - 1]), map[r][c]);
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    private static void initialize() {
        dp[0][0] = map[0][0];

        for (int r = 1; r < N; r++) {
            dp[r][0] = Math.max(map[r][0], dp[r-1][0]);
        }

        for (int c = 1; c < N; c++) {
            dp[0][c] = Math.max(map[0][c], dp[0][c - 1]);
        }
    }

}
