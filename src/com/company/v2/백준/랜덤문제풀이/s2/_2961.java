package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2961 {
    static int result = Integer.MAX_VALUE;
    static int N;
    static int[][] nums;
    static boolean[] checks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N][2];
        checks = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            recursion(0, 0, i);
        }

        System.out.println(result);
    }

    static void recursion(int depth, int start, int cnt) {
        if (depth == cnt) {
            result = Math.min(result, calculate());
            return;
        }

        for (int i = start; i < N; i++) {
            checks[i] = true;
            recursion(depth + 1, i + 1, cnt);
            checks[i] = false;
        }
    }

    static int calculate() {
        int aSum = 1;
        int bSum = 0;

        for (int i = 0; i < N; i++) {
            if (checks[i]) {
                aSum *= nums[i][0];
                bSum += nums[i][1];
            }
        }

        return Math.abs(aSum - bSum);
    }
}
