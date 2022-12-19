package com.company.v1.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865_냅색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int itemCnt = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        int[][] dp = new int[itemCnt + 1][maxWeight + 1];
        int[] weights = new int[itemCnt + 1];
        int[] values = new int[itemCnt + 1];

        for (int i = 1; i <= itemCnt; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= itemCnt; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                dp[i][j] = dp[i - 1][j]; // 이전 아이템의 value값 저장
                if(j - weights[i] >= 0) { // 현재 무게에서 자신의 무게를 뺏을때 남는 무게가 존재하면
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weights[i]] + values[i]); // 이전 아이템 valus vs 남은 무게의 가치 + 자신의 가치
                }
            }
        }

        System.out.println(dp[itemCnt][maxWeight]);
    }

}
