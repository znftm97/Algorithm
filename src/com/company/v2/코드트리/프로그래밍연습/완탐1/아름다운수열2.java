package com.company.v2.코드트리.프로그래밍연습.완탐1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 아름다운수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B, 0, M);

        int result = 0;
        int[] arr = new int[100];
        for (int i = 0; i < N - M + 1; i++) {

            for (int j = 0; j < M; j++) {
                arr[j] = A[i + j];
            }

            Arrays.sort(arr, 0, M);
            boolean isEquals = true;

            for (int j = 0; j < M; j++)
                if (arr[j] != B[j]) {
                    isEquals = false;
                    break;
                }

            if (isEquals) {
                result++;
            }
        }

        System.out.print(result);
    }


}
