package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182 {
    static int[] copyNums;
    static int[] nums;
    static int target, result, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            copyNums = new int[N];
            recursion(0, 0,i);
        }

        System.out.println(result);
    }

    static void recursion(int depth, int start, int end) {
        if (depth == end) {
            if(calculate()) result++;
            return;
        }

        for (int i = start; i < N; i++) {
            copyNums[depth] = nums[i];
            recursion(depth + 1, i + 1, end);
            copyNums[depth] = 0;
        }

    }

    static boolean calculate() {
        int sum = 0;
        for (int num : copyNums) {
            sum += num;
        }

        return sum == target;
    }
}
