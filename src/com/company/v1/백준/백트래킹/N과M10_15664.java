package com.company.v1.백준.백트래킹;

import java.util.*;
import java.io.*;

public class N과M10_15664 {
    private static int[] nums;
    private static int[] customNums;
    private static int N, M = 0;
    private static Set<String> result = new LinkedHashSet<>();
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        customNums = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        recursion(0, 0);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void recursion(int depth, int start){
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(customNums[i]).append(" ");
            }
            result.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for (int i = start; i < N; i++) {
            customNums[depth] = nums[i];
            recursion(depth + 1, i + 1);
        }
    }

}
