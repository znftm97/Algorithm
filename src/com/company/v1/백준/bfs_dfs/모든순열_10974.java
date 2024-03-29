package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모든순열_10974 {

    private static int[] nums;
    private static int[] customNums;
    private static boolean[] visit;
    private static int N = 0;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        customNums = new int[N];
        visit = new boolean[N];
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }

        Arrays.sort(nums);

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth){
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(customNums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            customNums[depth] = nums[i];
            dfs(depth + 1);
            visit[i] = false;
        }
    }

}
