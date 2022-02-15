package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {
    private static int[] nums;
    private static int result = 0;
    private static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(S == 0) System.out.println(result - 1);
        else System.out.println(result);
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) result++;
            return;
        }

        dfs(depth + 1, sum + nums[depth]);
        dfs(depth + 1, sum);
    }

}
