package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        long[][] dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if(map[r][c] == 0) break;

                int jump = map[r][c];
                if(r + jump <= N) dp[r + jump][c] += dp[r][c];
                if(c + jump <= N) dp[r][c + jump] += dp[r][c];
            }
        }

        System.out.println(dp[N][N]);
    }
}
