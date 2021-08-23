package com.company.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarray_10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int num = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(num, dp[i-1] + num);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);

    }
}
