package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
    private static final int BLACK = 1;
    private static final int WHITE = -1;
    private static int N, M;
    private static int[][] bMap;
    private static int[][] wMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        bMap = new int[N][M];
        wMap = new int[N][M];

        for (int r = 0; r < N; r++) {
            String[] strs = br.readLine().split("");

            for (int c = 0; c < M; c++) {
                if (strs[c].equals("W")) {
                    map[r][c] = WHITE;
                } else {
                    map[r][c] = BLACK;
                }
            }
        }

        makeBWMap();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                int bMapGap = 0;
                int wMapGap = 0;
                for (int r = i; r < i + 8; r++) {
                    for (int c = j; c < j + 8; c++) {
                        if (map[r][c] != bMap[r][c]) {
                            bMapGap++;
                        }

                        if (map[r][c] != wMap[r][c]) {
                            wMapGap++;
                        }

                    }
                }

                result = Math.min(result, Math.min(bMapGap, wMapGap));
            }
        }

        System.out.println(result);
    }

    /*검은색, 흰색으로 시작하는 각 체스판 만들기*/
    private static void makeBWMap() {
        bMap[0][0] = BLACK;
        wMap[0][0] = WHITE;

        for (int r = 1; r < N; r++) {
            bMap[r][0] = bMap[r - 1][0] * -1;
            wMap[r][0] = wMap[r - 1][0] * -1;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 1; c < M; c++) {
                bMap[r][c] = bMap[r][c - 1] * -1;
                wMap[r][c] = wMap[r][c - 1] * -1;
            }
        }
    }

}
