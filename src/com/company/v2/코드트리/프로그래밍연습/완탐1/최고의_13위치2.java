package com.company.v2.코드트리.프로그래밍연습.완탐1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최고의_13위치2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < N - 2; c1++) {
                for (int r2 = 0; r2 < N; r2++) {
                    for (int c2 = 0; c2 < N - 2; c2++) {
                        if (isEqualsBox(r1, c1, r2, c2)) {
                            continue;
                        }

                        int box1 = map[r1][c1] + map[r1][c1 + 1] + map[r1][c1 + 2];
                        int box2 = map[r2][c2] + map[r2][c2 + 1] + map[r2][c2 + 2];
                        result = Math.max(result, box1 + box2);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isEqualsBox(int r1, int c1, int r2, int c2) {
        return r1 == r2 && Math.abs(c2 - c1) <= 2;
    }
}
