package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == x) {
                result++;
                start++;
                end--;
            } else if (sum < x) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }

}
