package com.company.v1.코드트리.애드혹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 움직이는블록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        Arrays.sort(nums);

        int average = sum / N;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if(nums[i] >= average) break;
            else result += average - nums[i];
        }

        System.out.println(result);
    }

}
