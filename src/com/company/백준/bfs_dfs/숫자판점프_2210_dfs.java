package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판점프_2210_dfs {
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static Set<String> digits = new HashSet<>();
    private static final int mapSize = 5;

    public static void dfs(int r, int c, int depth, String s){
        if (depth == 6) {
            digits.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (notEscape(nr, nc)) {
                dfs(nr, nc, depth + 1, s + map[r][c]);
            }
        }
    }

    private static boolean notEscape(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < mapSize && nc < mapSize) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String str = "";
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                dfs(i, j, 0, str);
            }
        }

        System.out.println(digits.size());
        br.close();
    }

}
