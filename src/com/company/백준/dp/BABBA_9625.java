package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BABBA_9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] dpA = new int[K+1];
        int[] dpB = new int[K+1];
        dpA[0] = 1;
        dpB[0] = 0;

        for (int i = 1; i <= K; i++) {
            dpA[i] = dpB[i - 1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }

        System.out.println(dpA[K] + " " + dpB[K]);
        br.close();
    }

}
