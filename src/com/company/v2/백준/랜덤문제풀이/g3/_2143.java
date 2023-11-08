package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2143 {
    static int T,N,M;
    static int[] nums1, nums2;
    static List<Integer> sums1 = new ArrayList<>();
    static List<Integer> sums2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        nums1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            nums1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        nums2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) {
            nums2[i] = Integer.parseInt(st.nextToken());
        }

        calculateSum(N, nums1, sums1);
        calculateSum(M, nums2, sums2);

        System.out.println(getPairCnt());
        System.out.println();
    }

    static void calculateSum(int N, int[] nums, List<Integer> sums) {
        for(int i = 0; i<N; i++) {
            int sum = 0;
            for(int j = i; j<N; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }
    }

    static long getPairCnt() {
        Collections.sort(sums1);
        Collections.sort(sums2);

        long cnt = 0;
        int start = 0;
        int end = sums2.size() - 1;

        while(start < sums1.size() && end >= 0) {
            int sum = sums1.get(start) + sums2.get(end);
            if(sum == T) {
                int val1 = sums1.get(start);
                int val2 = sums2.get(end);
                long cnt1 = 0;
                long cnt2 = 0;

                while (start < sums1.size() && val1 == sums1.get(start)) {
                    start++;
                    cnt1++;
                }

                while (end >= 0 && val2 == sums2.get(end)) {
                    end--;
                    cnt2++;
                }

                cnt += cnt1 * cnt2;
            } else if(sum > T) {
                end--;
            } else {
                start++;
            }
        }

        return cnt;
    }
}
