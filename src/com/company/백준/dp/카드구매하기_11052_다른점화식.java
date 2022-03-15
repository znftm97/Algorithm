package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기_11052_다른점화식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cardCnt = Integer.parseInt(br.readLine());
        int[] cards = new int[cardCnt + 1];
        int[] dp = new int[cardCnt + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cardCnt; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = cards[1];
        for (int i = 2; i <= cardCnt; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + cards[j]);
            }
        }

        System.out.println(dp[cardCnt]);
    }

}
