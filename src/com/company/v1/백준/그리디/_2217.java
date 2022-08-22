package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ropeCount = Integer.parseInt(br.readLine());
        int[] arr = new int[ropeCount];

        for (int i = 0; i < ropeCount; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = ropeCount-1; i >= 0; i--) {
            arr[i] = arr[i] * (ropeCount - i);
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}
