package com.company.v2.코드트리.LV4.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수사각형_최솟값의_최대 {
    private static int[][] map, dp;
    private static int N;

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
                dp[r][c] = Math.min(Math.max(dp[r - 1][c], dp[r][c - 1]), map[r][c]);
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    private static void initialize() {
        dp[0][0] = map[0][0];

        for (int c = 1; c < N; c++) {
            dp[0][c] = Math.min(dp[0][c - 1], map[0][c]);
        }

        for (int r = 1; r < N; r++) {
            dp[r][0] = Math.min(dp[r-1][0], map[r][0]);
        }
    }

}
