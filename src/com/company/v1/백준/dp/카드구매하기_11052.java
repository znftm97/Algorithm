package com.company.v1.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기_11052 {
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
            // dp[8] + dp[2] 나 dp[2] + dp[8] 똑같기때문에 2로 나눴다. 대신 이러면 cards[i]를 한번 더 비교해줘야 한다.
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(cards[i], dp[i - j] + dp[j]));
            }
        }

        System.out.println(dp[cardCnt]);
    }

}
