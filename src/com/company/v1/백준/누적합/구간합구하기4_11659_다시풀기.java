package com.company.v1.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4_11659_다시풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        int[] accumulates = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            accumulates[i] = accumulates[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            int sum = accumulates[endIndex] - accumulates[startIndex - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
