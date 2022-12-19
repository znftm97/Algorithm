package com.company.v1.코드트리.알고리즘기본.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대거리의점 {
    private static int N, M;
    private static int[] coordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coordinates = new int[N];

        for (int i = 0; i < N; i++) {
            coordinates[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coordinates);

        int start = 1;
        int end = coordinates[N - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(mid)) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isPossible(int mid) {

        int stuffCnt = M - 1;
        int beforeIdx = 0;

        for (int i = 1; i < N; i++) {
            if (coordinates[i] - coordinates[beforeIdx] < mid) {
                continue;
            }

            beforeIdx = i;
            stuffCnt--;
        }

        return stuffCnt <= 0;
    }

}
