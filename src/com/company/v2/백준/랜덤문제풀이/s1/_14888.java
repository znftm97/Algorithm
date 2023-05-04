package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888 {
    private static final int PLUS = 1;
    private static final int MINUS = 2;
    private static final int MULTIPLY = 3;
    private static final int DIVIDE = 4;
    private static int N;
    private static int PLUS_CNT, MINUS_CNT, MULTIPLY_CNT, DIVIDE_CNT;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int[] nums;
    private static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        PLUS_CNT = Integer.parseInt(st.nextToken());
        MINUS_CNT = Integer.parseInt(st.nextToken());
        MULTIPLY_CNT = Integer.parseInt(st.nextToken());
        DIVIDE_CNT = Integer.parseInt(st.nextToken());
        int total = PLUS_CNT + MINUS_CNT + MULTIPLY_CNT + DIVIDE_CNT;
        operators = new int[total];

        recursion(0, 0, 0, 0, 0, total);

        System.out.println(max);
        System.out.println(min);
    }

    private static void recursion(int depth, int plusCnt, int minusCnt, int multiplyCnt, int divideCnt, int total) {
        if (depth == total) {
            calculate();
            return;
        }

        if (plusCnt < PLUS_CNT) {
            operators[depth] = PLUS;
            recursion(depth + 1, plusCnt + 1, minusCnt, multiplyCnt, divideCnt, total);
        }
        if (minusCnt < MINUS_CNT) {
            operators[depth] = MINUS;
            recursion(depth + 1, plusCnt, minusCnt + 1, multiplyCnt, divideCnt, total);
        }
        if (multiplyCnt < MULTIPLY_CNT) {
            operators[depth] = MULTIPLY;
            recursion(depth + 1, plusCnt, minusCnt, multiplyCnt + 1, divideCnt, total);
        }
        if (divideCnt < DIVIDE_CNT) {
            operators[depth] = DIVIDE;
            recursion(depth + 1, plusCnt, minusCnt, multiplyCnt, divideCnt + 1, total);
        }
    }

    private static void calculate() {
        int sum = nums[0];
        for (int i = 1; i < N; i++) {
            if (operators[i-1] == PLUS) sum += nums[i];
            if (operators[i-1] == MINUS) sum -= nums[i];
            if (operators[i-1] == MULTIPLY) sum *= nums[i];
            if (operators[i-1] == DIVIDE) {
                if (sum < 0) {
                    sum = (sum * -1 / nums[i]) * -1;
                } else {
                    sum /= nums[i];
                }
            }
        }

        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }
}
