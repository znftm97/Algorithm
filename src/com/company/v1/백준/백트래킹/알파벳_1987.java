package com.company.v1.백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
    private static int R, C;
    private static char[][] map;
    private static boolean[][] visitMap;
    private static boolean[] visitAlphabet;
    private static int result = 0;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitMap = new boolean[R][C];
        visitAlphabet = new boolean[26];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int r, int c, int depth){
        if(visitAlphabet[map[r][c] - 'A']){
            result = Math.max(result, depth);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && isNotVisit(nr, nc)) {
                visitAlphabet[map[r][c] - 'A'] = true;
                dfs(nr, nc, depth + 1);
                visitAlphabet[map[r][c] - 'A'] = false;
            }
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visitMap[r][c];
    }

}
