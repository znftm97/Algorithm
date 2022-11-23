package com.company.v2.코드트리.LV4.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수사각형최소합 {
    private static int[][] arr, dp;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initialize();

        for (int r = 1; r < N; r++) {
            for (int c = N - 2; c >= 0; c--) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c + 1]) + arr[r][c];
            }
        }

        System.out.println(dp[N - 1][0]);
    }

    private static void initialize() {
        dp[0][N - 1] = arr[0][N - 1];

        //맨 위 가로줄 채우기
        for (int c = N - 2; c >= 0; c--) {
            dp[0][c] = arr[0][c] + dp[0][c + 1];
        }

        // 맨 오른쪽 세로줄 채우기
        for (int r = 1; r < N; r++) {
            dp[r][N - 1] = arr[r][N - 1] + dp[r - 1][N - 1];
        }
    }

}
