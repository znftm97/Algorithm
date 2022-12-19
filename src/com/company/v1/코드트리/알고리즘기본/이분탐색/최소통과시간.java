package com.company.v1.코드트리.알고리즘기본.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소통과시간 {

    private static long N, M;
    private static long[] movetimes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        movetimes = new long[(int)M];

        for (int i = 0; i < M; i++) {
            movetimes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(movetimes);

        long start = 1;
        long end = movetimes[(int)M - 1] * movetimes[(int)M - 1];
        long result = movetimes[(int)M - 1] * movetimes[(int)M - 1];

        while (start <= end) {
            long mid = (start + end) / 2; // mid ==  N개 물건을 모두 통과시키는데 걸리는 최소 시간

            if (isPossible(mid)) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isPossible(long mid) {
        long ableMoveStuffCnt = 0;

        for (long moveTime : movetimes) {
            ableMoveStuffCnt += mid / moveTime;
        }

        return ableMoveStuffCnt >= N;
    }

}
