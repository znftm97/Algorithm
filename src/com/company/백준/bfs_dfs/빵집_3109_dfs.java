package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_3109_dfs {
    private static String[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 0, 1};
    private static int[] dc = {1, 1, 1};
    private static int R,C;
    private static int maxPipe;

    private static boolean dfs(int r, int c){
        visit[r][c] = true;

        if (c == C - 1) {
            maxPipe++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(notEscape(nr, nc) && notVisit(nr, nc) && isEmpty(nr, nc)){
                if(dfs(nr, nc)) return true;
            }
        }

        return false;
    }

    private static boolean notEscape(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
            return true;
        }

        return false;
    }

    private static boolean notVisit(int nr, int nc){
        if (!visit[nr][nc]) {
            return true;
        }

        return false;
    }

    private static boolean isEmpty(int nr, int nc){
        if (map[nr][nc].equals(".")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j];
            }
        }

        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }

        System.out.println(maxPipe);
        br.close();
    }

}
