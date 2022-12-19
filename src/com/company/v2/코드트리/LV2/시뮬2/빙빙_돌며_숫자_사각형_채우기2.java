package com.company.v2.코드트리.LV2.시뮬2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙빙_돌며_숫자_사각형_채우기2 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dr = {-1, 0, 1, 0}; // 북,동,남,서
        int[] dc = {0, 1, 0, -1};
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        int endNum = N * M;
        int nowNum = 2;
        int r = 0;
        int c = 0;
        int dir = 2;
        map[r][c] = 1;
        visit[r][c] = true;

        while (nowNum <= endNum) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isNotAbleArea(nr, nc) || isVisit(nr, nc)) {
                dir = changeDir(dir);
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            map[nr][nc] = nowNum++;
            visit[nr][nc] = true;
            r = nr;
            c = nc;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isNotAbleArea(int r, int c) {
        return !(r >= 0 && c >= 0 && r < N && c < M);
    }

    private static boolean isVisit(int r, int c) {
        return visit[r][c];
    }

    private static int changeDir(int dir) {
        if (dir == 0) {
            dir = 3;
        } else {
            dir -= 1;
        }

        return dir;
    }

}
