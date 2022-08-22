package com.company.v1.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n+2];
        int[] pay = new int[n+2];
        int[] dp = new int[n+2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 시작
        for (int i = n; i > 0; i--) {
            int index = i + time[i];

            if(index > n + 1)
                dp[i] = dp[i+1]; // 뒤에서부터 시작하므로 dp[i+1]이 이전값 느낌
            else
                dp[i] = Math.max(dp[i+1], pay[i] + dp[index]);
        }

        System.out.println(dp[1]);
    }
}
