package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식물피하기_1743_dfs {
    private static int[][] map;
    private static boolean[][] visit;
    private static int R, C, foodWasteCnt;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C + 1];
        visit = new boolean[R + 1][C + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        int foodWasteMaxCnt = 0;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (isNotVisit(r, c) && map[r][c] == -1) {
                    foodWasteCnt = 0;
                    getFoodWasteSize(r, c);
                    foodWasteMaxCnt = Math.max(foodWasteMaxCnt, foodWasteCnt);
                }
            }
        }

        System.out.println(foodWasteMaxCnt);
    }

    private static void getFoodWasteSize(int r, int c){
        visit[r][c] = true;
        foodWasteCnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && isFoodWaste(nr, nc)) {
                getFoodWasteSize(nr, nc);
            }
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r > 0 && c > 0 && r <= R && c <= C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isFoodWaste(int r, int c){
        return map[r][c] == -1;
    }

}
