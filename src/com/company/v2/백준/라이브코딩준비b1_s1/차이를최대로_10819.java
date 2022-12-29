package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {
    private static int result, N = 0;
    private static int[] nums, copyNums;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        copyNums = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0);

        System.out.println(result);
    }

    private static void recursion(int depth) {
        if (depth == N) {
            int sum = sum(copyNums);
            result = Math.max(result, sum);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            copyNums[depth] = nums[i];
            recursion(depth + 1);
            visit[i] = false;
        }
    }

    private static int sum(int[] nums) {
        int sum = 0;
        int start = 0;
        int end = 1;

        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(nums[start++] - nums[end++]);
        }

        return sum;
    }

}
