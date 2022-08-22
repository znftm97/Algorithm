package com.company.v1.백준.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920_이분탐색직접구현_시간더오래걸림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] targetNums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            targetNums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(targetNums);

        for (int num : nums){
            int start = 0;
            int end = targetNums.length - 1;
            boolean flag = false;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (num < targetNums[mid]) {
                    end = mid - 1;
                } else if (num > targetNums[mid]) {
                    start = mid + 1;
                } else {
                    sb.append("1").append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

}
