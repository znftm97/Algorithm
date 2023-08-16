package com.company.v2.백준.랜덤문제풀이.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;

            int lb = lowerBound(start, end, target, nums);
            int ub = upperBound(start, end, target, nums);

            sb.append(ub - lb).append(" ");
        }

        System.out.println(sb);
    }

    private static int lowerBound(int start, int end, int target, int[] nums) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }

    private static int upperBound(int start, int end, int target, int[] nums) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }
}
