package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {

    private static int[] nums;
    private static int[] customNums;
    private static boolean[] visit;
    private static int N = 0;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        customNums = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int depth){
        if (depth == N) {
            result = Math.max(result, calculate());
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

    private static int calculate(){
        int sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(customNums[i] - customNums[i + 1]);
        }

        return sum;
    }

}
