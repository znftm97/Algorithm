package com.company.v2.백준.이분탐색;

import java.io.*;
import java.util.*;

public class 랜선자르기_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lans = new long[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans);

        long min = 1;
        long max = lans[K - 1];

        while (min <= max) {
            long mid =  (min + max) / 2;
            long lanCount = getLanCount(lans, mid);

            if (lanCount >= N) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }

    private static long getLanCount(long[] lans, long mid) {
        long result = 0;

        for (long lan : lans) {
            result += lan / mid;
        }

        return result;
    }

}

