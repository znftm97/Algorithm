package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] lans = new int[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans);

        long start = 1;
        long end = lans[K - 1];
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long lanCnt = getLanCnt(mid, lans);

            if (lanCnt >= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start - 1);
    }

    private static long getLanCnt(long mid, int[] lans) {
        long sum = 0;
        for (long lan : lans) {
            sum += lan / mid;
        }

        return sum;
    }
}
