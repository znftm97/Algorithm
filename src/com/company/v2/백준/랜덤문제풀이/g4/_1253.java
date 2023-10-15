package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];

                if (start == i) start++;
                else if(end == i) end--;
                else {
                    if(nums[i] < sum) end--;
                    else if (nums[i] > sum) start++;
                    else {
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
