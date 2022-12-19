package com.company.v1.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순서쌍의곱의합_13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        long[] dp = new long[N + 1];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < N - 1; i++) {
            sum += nums[i] * (dp[N] - dp[i + 1]);
        }

        System.out.println(sum);
        br.close();
    }

}
