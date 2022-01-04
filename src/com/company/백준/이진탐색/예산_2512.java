package com.company.백준.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] regionBudgets = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            regionBudgets[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(regionBudgets);

        long maxBudget = Long.parseLong(br.readLine());
        long start = 0;
        long end = regionBudgets[N - 1];
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (long budget : regionBudgets) {
                if (mid <= budget) sum += mid;
                else sum += budget;
            }

            if (sum <= maxBudget) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
        br.close();
    }

}
