package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*처음으로 혼자 푼 dp 문제!*/
public class 정수삼각형_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            /*한번 반복할 때 대각선으로 두 수를 계산한다. 즉 배열로 치면 ㄴ 형태로 계산을 하게 된다.
            * */
            for (int j = 0; j < i; j++) {
                /*여기서 값을 넣을 때 기존 dp에 있는 값과 비교해서 넣어야함
                *    7                         7
                *  3   8       -->        10        15
                * 8  1  0             18   max(16,11)   15
                * 위 구조일 때 7->3->1=11 vs 7->8->1=16 두 값중 큰 값을 넣어여 하므로
                * 처음에 11을 계산할 때는 그냥 값이 들어가지만, 16값을 넣을 때 Math.max로 11, 16 중 큰 값을 넣도록
                * */
                dp[i][j] = Math.max((arr[i][j] + dp[i - 1][j]), dp[i][j]);
                dp[i][j+1] = arr[i][j+1] + dp[i - 1][j];
            }
        }

        /*최대값은 어차피 맨 아래 즉 배열의 마지막행에 있으므로 n-1행에서 최대값 찾기*/
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }

        System.out.println(max);
    }
}
