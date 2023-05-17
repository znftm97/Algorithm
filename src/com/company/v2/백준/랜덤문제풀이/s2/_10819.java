package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819 {
    private static int[] nums;
    private static int[] copyNums;
    private static boolean[] visit;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        copyNums = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, N);
        System.out.println(result);
    }

    private static void recursion(int depth, int N) {
        if (depth == N) {
            result = Math.max(result, getSum());
        }

        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;
            copyNums[depth] = nums[i];
            visit[i] = true;
            recursion(depth + 1, N);
            visit[i] = false;
        }
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < copyNums.length - 1; i++) {
            sum += Math.abs(copyNums[i] - copyNums[i + 1]);
        }
        return sum;
    }
}
