package com.company.v2.코드트리.LV2.Ad_Hoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 움직이는_블록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] blocks = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            blocks[i] = Integer.parseInt(br.readLine());
            sum += blocks[i];
        }

        int avgBlock = sum / N;
        int result = 0;
        for (int block : blocks) {
            result += Math.abs(block - avgBlock);
        }

        System.out.println(result / 2);
    }

}
