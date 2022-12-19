package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양수_직사각형의_최대크기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSize = -1;
        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = c1; c2 < M; c2++) {
                        if (hasNotNegativeNum(r1, c1, r2, c2, map)) {
                            int size = (r2 - r1 + 1) * (c2 - c1 + 1);
                            maxSize = Math.max(maxSize, size);
                        }
                    }
                }
            }
        }

        System.out.println(maxSize);
    }

    private static boolean hasNotNegativeNum(int r1, int c1, int r2, int c2, int[][] map) {
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (map[r][c] <= 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
