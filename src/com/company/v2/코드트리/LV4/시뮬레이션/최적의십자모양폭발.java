package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적의십자모양폭발 {
    private static int N;
    private static int[][] originMap, copyMap;
    private static final int NONE = 0;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    private static final int[] turn = {1, 0, 3, 2};
    private static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        originMap = new int[N][N];
        copyMap = new int[N][N];
        visit = new boolean[N][N][4];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                originMap[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                init();
                boom(r, c);
                drop();
                result = Math.max(result, getPairCount());
            }
        }

        System.out.println(result);
    }

    private static void boom(int boomR, int boomC) {
        int maxRange = originMap[boomR][boomC];
        copyMap[boomR][boomC] = NONE;

        if (maxRange == 1) {
            return;
        }

        for (int range = 1; range < maxRange; range++) {
            for (int dir = 0; dir < 4; dir++) {
                int nr = boomR + dr[dir] * range;
                int nc = boomC + dc[dir] * range;

                if (isAbleArea(nr, nc)) {
                    copyMap[nr][nc] = NONE;
                }
            }
        }
    }

    private static void drop() {
        int[][] tmp = new int[N][N];

        for (int c = 0; c < N; c++) {
            int nr = N - 1;
            for (int r = N - 1; r >= 0; r--) {
                if (copyMap[r][c] != NONE) {
                    tmp[nr--][c] = copyMap[r][c];
                }
            }
        }

        for (int r = 0; r < N; r++) {
            copyMap[r] = tmp[r].clone();
        }
    }

    private static int getPairCount() {
        int pairCnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (copyMap[r][c] == NONE) {
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (isAbleArea(nr, nc) && isNotVisited(r, c, dir) && copyMap[r][c] == copyMap[nr][nc]) {
                        pairCnt++;
                        visit[r][c][dir] = true;
                        visit[nr][nc][turn[dir]] = true;
                    }
                }
            }
        }

        return pairCnt;
    }

    private static void init() {
        for (int r = 0; r < N; r++) {
            copyMap[r] = originMap[r].clone();

            for (int c = 0; c < N; c++) {
                for (int dir = 0; dir < 4; dir++) {
                    visit[r][c][dir] = false;
                }
            }
        }
    }

    private static boolean isAbleArea(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static boolean isNotVisited(int r, int c, int dir) {
        return !visit[r][c][dir];
    }

}
