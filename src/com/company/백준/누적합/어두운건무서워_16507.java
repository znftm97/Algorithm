package com.company.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운건무서워_16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        int[][] dp = new int[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= C; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int sum = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
            int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append(sum / cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
