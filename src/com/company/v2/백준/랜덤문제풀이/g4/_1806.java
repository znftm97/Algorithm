package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1806 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int minLen = Integer.MAX_VALUE;
        if(nums[start] >= target || nums[end] >= target) {
            System.out.println(1);
            return;
        }

        long sum = nums[start] + nums[end];
        while(end < N){
            if(sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            } else {
                end++;
                if (end < N) sum += nums[end];
            }
        }

        if(minLen == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLen);
    }
}
