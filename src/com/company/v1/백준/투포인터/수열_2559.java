package com.company.v1.백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = K-1; // 연속적인 k일이라고 주어졌으므로 end위치를 k에 위치하도록 (배열인덱스라 -1)
        int maxSum = Integer.MIN_VALUE; // 온도가 음수로만 주어질 수도 있으므로 0으로 하면 틀림

        while (true) {
            int sum = 0; // sum 초기화

            /*탈출조건*/
            if (end == N) {
                break;
            }

            /*사이에 속한 값 모두 더함*/
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);

            start++;
            end++;
        }

        System.out.println(maxSum);
    }
}
