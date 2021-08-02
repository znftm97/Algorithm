package com.company.백준.dp.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*조건에 따라 첫 요소는 1, 두 번재 요소는 0으로 고정된다
 * 즉 n이 1과 2일때의 경우의 수는 1이다.
 * 그리고 경우의 수를 쭉 나열해 보면 1 1 2 3 5 8 13 .... 형태이다.
 * 즉 피보나치 수열과 똑같은 점화식으로 풀 수 있다.
 * 피보나치 수열 문제에서 n 값이 최대 90일때 int형은 범위를 초과하므로 long 배열을 사용하자.
 * */
public class 이친수_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[n]);
    }
}
