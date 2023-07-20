package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxArr = new int[N][3];
        int[][] minArr = new int[N][3];

        for(int i = 0; i<1; i++){
            for(int j = 0; j<3; j++){
                maxArr[i][j] = arr[i][j];
                minArr[i][j] = arr[i][j];
            }
        }

        for(int i = 1; i<N; i++){
            maxArr[i][0] = arr[i][0] + Math.max(maxArr[i-1][0], maxArr[i-1][1]);
            maxArr[i][1] = arr[i][1] + Math.max(maxArr[i-1][0], Math.max(maxArr[i-1][1], maxArr[i-1][2]));
            maxArr[i][2] = arr[i][2] + Math.max(maxArr[i-1][1], maxArr[i-1][2]);
            minArr[i][0] = arr[i][0] + Math.min(minArr[i-1][0], minArr[i-1][1]);
            minArr[i][1] = arr[i][1] + Math.min(minArr[i-1][0], Math.min(minArr[i-1][1], minArr[i-1][2]));
            minArr[i][2] = arr[i][2] + Math.min(minArr[i-1][1], minArr[i-1][2]);
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i<3; i++){
            max = Math.max(max, maxArr[N-1][i]);
            min = Math.min(min, minArr[N-1][i]);
        }

        System.out.println(max + " " + min);
    }
}
