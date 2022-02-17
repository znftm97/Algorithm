package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_15654 {
    private static int[] nums;
    private static int[] customNums;
    private static boolean[] visit;
    private static int N, M = 0;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        customNums = new int[N];
        visit = new boolean[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int depth){
        if (depth == M) {
            for (int i = 0; i < M; i++) {
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
