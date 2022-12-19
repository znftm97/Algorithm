package com.company.v1.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀아르바이트_12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalDay = Integer.parseInt(st.nextToken());
        int workingDay = Integer.parseInt(st.nextToken());
        long[] dp = new long[totalDay + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= totalDay; i++) {
            dp[i] = dp[i - 1] + Long.parseLong(st.nextToken());
        }

        long max = 0; // 음수 없으니 0으로 초기화
        for (int i = workingDay; i <= totalDay; i++) {
            max = Math.max(max, dp[i] - dp[i-workingDay]);
        }

        System.out.println(max);
        br.close();
    }

}
