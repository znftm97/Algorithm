package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603 {
    private static final int LOTTO_LIMIT = 6;
    private static int K;
    private static int[] nums, copyNums;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) return;

            nums = new int[K];
            copyNums = new int[LOTTO_LIMIT];

            for (int i = 0; i < K; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            recursion(0, 0);
        }
    }

    private static void recursion(int depth, int start) {
        if (depth == LOTTO_LIMIT) {
            print();
            return;
        }

        for (int i = start; i < K; i++) {
            copyNums[depth] = nums[i];
            recursion(depth + 1, i + 1);
        }
    }

    private static void print() {
        for (int num : copyNums) sb.append(num).append(" ");
        System.out.println(sb);
        sb.setLength(0);
    }
}
