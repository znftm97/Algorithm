package com.company.v1.코드트리.알고리즘기본.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 삼오무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long start = 1;
        long end = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            long mooCnt = (mid / 3) + (mid / 5) - (mid / 15);
            long numCnt = mid - mooCnt;

            if (numCnt == N && mid % 3 != 0 && mid % 5 != 0) {
                System.out.println(mid);
                return;
            } else if (numCnt < N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

    }

}
