package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (Comparator.comparingInt(o -> o[0])));
            int min = arr[0][1];
            int passCnt = 1;

            for (int i = 1; i < N; i++) {
                if(min > arr[i][1]) {
                    passCnt++;
                    min = arr[i][1];
                }
            }

            System.out.println(passCnt);
        }
    }
}
