package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 11053문제에서 연속되는 가장 긴 증가하는 부분수열을 구하는 풀이이다.
* 하지만 문제는 연속되지 않은 경우에도 가장 긴 부분수열을 구하는 문제이다.
* 만약 연속된이라는 조건이 붙으면 아래와 같이 풀자.
* */
public class 가장긴증가하는부분수열_커스텀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int tmp = 0;

            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }

            tmp = dp[i];
            if (max < tmp) {
                max = tmp;
            }
        }

        if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(max);
        }
    }
}
