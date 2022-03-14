package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                // arr에서 현재 나보다(arr[i]) 작은애들중에서 , dp값이 +1 했을때 나보다 크다면, 해당 값 저장
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
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
