package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            /*dp의 이전요소값 + 현재 arr요소값  vs  현재 arr요소값 중 큰 수를 넣음*/
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        /*맨 첫번째 요소가 최대값인 경우 예외처리*/
        if (max < arr[0]) {
            System.out.println(arr[0]);
        } else {
            System.out.println(max);
        }
    }
}
