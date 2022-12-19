package com.company.v1.백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int val = arr[i];

            for (int j = i + 1; j < N; j++) {
                if (val < arr[j]) {
                    sb.append(arr[j]).append(" ");
                    break;
                } else if (j == N - 1 && (val >= arr[j])) {
                    sb.append(-1).append(" ");
                }
            }
        }
        sb.append(-1).append(" ");

        System.out.println(sb);
    }
}