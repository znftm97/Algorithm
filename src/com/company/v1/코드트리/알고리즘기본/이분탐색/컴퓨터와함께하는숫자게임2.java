package com.company.v1.코드트리.알고리즘기본.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴퓨터와함께하는숫자게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long M = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int minResult = Integer.MAX_VALUE;
        int maxResult = 0;

        for (long target = a; target <= b; target++) {
            int cnt = 0;
            long start = 1;
            long end = M;

            while (start <= end) {
                cnt++;
                long mid = (start + end) / 2;

                if (mid == target) {
                    break;
                }else if (mid > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            minResult = Math.min(minResult, cnt);
            maxResult = Math.max(maxResult, cnt);
        }

        System.out.println(minResult + " " + maxResult);
    }

}
