package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_2 {
    private static int[] nums;
    private static int[] operators;
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        recursion(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void recursion(int num, int depth) {
        if (depth == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0 -> recursion(num + nums[depth], depth + 1);
                    case 1 -> recursion(num - nums[depth], depth + 1);
                    case 2 -> recursion(num * nums[depth], depth + 1);
                    case 3 -> recursion(num / nums[depth], depth + 1);
                }

                operators[i]++;
            }
        }
    }
}
