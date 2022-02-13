package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양치기꿍_3187_dfs {

    private static char[][] map;
    private static boolean[][] visit;
    private static int R, C, totalSheepCnt, totalWolfCnt, sheepCnt, wolfCnt;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isNotFence(i, j) && isNotVisit(i, j)) {
                    sheepCnt = 0;
                    wolfCnt = 0;
                    dfs(i, j);

                    if(wolfCnt >= sheepCnt) totalWolfCnt += wolfCnt;
                    else totalSheepCnt += sheepCnt;
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    private static void dfs(int r, int c) {
        visit[r][c] = true;

        if(map[r][c] == 'v') wolfCnt++;
        else if (map[r][c] == 'k') sheepCnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && isNotFence(nr, nc)) {
                dfs(nr, nc);
            }
        }

    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isNotFence(int r, int c){
        return map[r][c] != '#';
    }

}
