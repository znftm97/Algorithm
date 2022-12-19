package com.company.v1.백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096_dp랑슬윈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] maxScores = new int[N][3];
        int[][] minScores = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            maxScores[0][i] = arr[0][i];
            minScores[0][i] = arr[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxScores[i][j] = Math.max(maxScores[i - 1][j] + arr[i][j], maxScores[i - 1][j + 1] + arr[i][j]);
                    minScores[i][j] = Math.min(minScores[i - 1][j] + arr[i][j], minScores[i - 1][j + 1] + arr[i][j]);
                } else if (j == 1) {
                    maxScores[i][j] = Math.max(Math.max(maxScores[i - 1][j - 1] + arr[i][j], maxScores[i - 1][j] + arr[i][j]), maxScores[i - 1][j + 1] + arr[i][j]);
                    minScores[i][j] = Math.min(Math.min(minScores[i - 1][j - 1] + arr[i][j], minScores[i - 1][j] + arr[i][j]), minScores[i - 1][j + 1] + arr[i][j]);
                } else {
                    maxScores[i][j] = Math.max(maxScores[i - 1][j] + arr[i][j], maxScores[i - 1][j - 1] + arr[i][j]);
                    minScores[i][j] = Math.min(minScores[i - 1][j] + arr[i][j], minScores[i - 1][j - 1] + arr[i][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(max < maxScores[N-1][i]) max = maxScores[N - 1][i];
            if(min > minScores[N-1][i]) min = minScores[N - 1][i];
        }

        System.out.println(max + " " + min);
        br.close();
    }
}
