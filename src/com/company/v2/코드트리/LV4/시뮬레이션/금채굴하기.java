package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금채굴하기 {

    private static final int GOLD = 1;
    private static int N;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int goldCost = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int maxGoldCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int R = 0; R < N; R++) {
            for (int C = 0; C < N; C++) {
                for (int K = 0; K <= 2 * (N - 1); K++) {

                    int cost = K * K + (K + 1) * (K + 1); // 마름모 넓이
                    int goldCnt = 0;

                    for (int r = 0; r < N; r++) {
                        for (int c = 0; c < N; c++) {
                            if (isInRhombus(R, C, r, c, K) && map[r][c] == GOLD) {
                                goldCnt++;
                            }
                        }
                    }

                    int profit = goldCnt * goldCost;
                    if (profit >= cost) {
                        maxGoldCnt = Math.max(maxGoldCnt, goldCnt);
                    }
                }
            }
        }

        System.out.println(maxGoldCnt);
    }

    // 마름모 영역인지 확인
    private static boolean isInRhombus(int R, int C, int r, int c, int K) {
        return Math.abs(R - r) + Math.abs(C - c) <= K;
    }

}
