package com.company.v2.코드트리.프로그래밍연습.Ad_Hoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2개씩_그룹짓기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[2*N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = N;

        for (int i = 0; i < N; i++) {
            result = Math.min(result, nums[idx2++] - nums[idx1++]);
        }

        System.out.println(result);
    }

}
