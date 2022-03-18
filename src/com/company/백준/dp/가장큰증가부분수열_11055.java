package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가부분수열_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dp[i] = nums[i];

            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[i] < dp[j] + nums[i]) {
                    dp[i] = dp[j] + nums[i];
                }
            }
        }

        int max = -1;
        for(int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

}
