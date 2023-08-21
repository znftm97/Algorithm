package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K + 1][N + 1];

        Arrays.fill(dp[1], 1);
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % 1000000000;
            }
        }

        System.out.println(dp[K][N] % 1000000000);
    }
}
