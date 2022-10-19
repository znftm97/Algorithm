package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N과M12_15666 {

    private static int[] nums;
    private static int[] tmpNums;
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    private static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        tmpNums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0, 0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(tmpNums[i]).append(" ");
            }

            set.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for (int i = start; i < N; i++) {
            tmpNums[depth] = nums[i];
            dfs(i, depth + 1);
        }

    }

}
