package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][maxWeight + 1];
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int weight = 1; weight <= maxWeight; weight++) {
                dp[i][weight] = dp[i - 1][weight];
                if (weight- weights[i] >= 0) {
                    dp[i][weight] = Math.max(dp[i][weight], dp[i - 1][weight- weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[N][maxWeight]);
    }
}
