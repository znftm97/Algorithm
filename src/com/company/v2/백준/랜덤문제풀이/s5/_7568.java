package com.company.v2.백준.랜덤문제풀이.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7568 {
    private static int[][] bodies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        bodies = new int[N][2];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bodies[i][0] = Integer.parseInt(st.nextToken());
            bodies[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int overCount = 0;

            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                if (isMoreLarge(i, j)) overCount++;
            }

            result[i] = overCount + 1;
        }

        for (int rank : result) {
            System.out.println(rank);
        }
    }

    private static boolean isMoreLarge(int i, int j) {
        return bodies[i][0] < bodies[j][0] && bodies[i][1] < bodies[j][1];
    }
}
