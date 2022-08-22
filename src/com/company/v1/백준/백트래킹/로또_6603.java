package com.company.v1.백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또_6603 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] nums;
    private static int[] customNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            nums = new int[k];
            customNums = new int[6];

            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            recursion(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recursion(int depth, int start){
        if(depth == 6){
            for (int num : customNums) {
                sb.append(num).append(" ");
            }

            sb.append("\n");
            return;
        }

        for (int i = start; i < nums.length; i++) {
            customNums[depth] = nums[i];
            recursion(depth + 1, i + 1);
        }
    }

}
