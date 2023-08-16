package com.company.v2.백준.랜덤문제풀이.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i< M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N - 1;
            boolean hasNum = false;

            while(start <= end) {
                int mid = start + (end - start) / 2;

                if(nums[mid] > target) end = mid - 1;
                else if(nums[mid] < target) start = mid + 1;
                else {
                    hasNum = true;
                    break;
                }
            }

            if(hasNum) System.out.println(1);
            else System.out.println(0);
        }
    }
}
