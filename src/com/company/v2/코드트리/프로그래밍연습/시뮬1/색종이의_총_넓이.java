package com.company.v2.코드트리.프로그래밍연습.시뮬1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이의_총_넓이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int MAX = 100;
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[MAX * 2 + 1][MAX * 2 + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int leftDownR = Integer.parseInt(st.nextToken()) + MAX;
            int leftDownC = Integer.parseInt(st.nextToken()) + MAX;
            int rightUpR = leftDownR + 8;
            int rightUpC = leftDownC + 8;

            for (int r = leftDownR; r < rightUpR; r++) {
                for (int c = leftDownC; c < rightUpC; c++) {
                    if(arr[r][c]) {
                        continue;
                    }

                    arr[r][c] = true;
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
