package com.company.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기상청인턴신현수_2345 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] temperature = new int[n];
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        /*n이 10일때 기준으로 k가 2일때 -> 총 9번 수행
         *     10일때 기준으로 k가 3일떄 -> 총 8번 수행
         * 즉 n-k+1번 반복해주면 된다.
         * */
        for (int i = 0; i < n-k+1; i++) {
            for (int j = i; j < i+k; j++) {
                dp[i] += temperature[j];
            }
            max = Math.max(max, dp[i]); // 만약 dp값 구하는 반복문에서 최대값 바로 안구하고
                                        // dp 길이만큼 반복문 따로 돌려서 최대값 찾으려면, 0이 들어있어서 최대값이 음수인경우 틀림, 예외처리 해줘야함
        }

        System.out.println(max);
    }
}
