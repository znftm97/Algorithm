package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해_21736 {
    private static char[][] map;
    private static boolean[][] visit;
    private static int R, C, friendCnt;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        int r = 0;
        int c = 0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'I') {
                    r = i;
                    c = j;
                }
            }
        }

        findFriends(r, c);
        if(friendCnt == 0) System.out.println("TT");
        else System.out.println(friendCnt);
    }

    private static void findFriends(int r, int c){
        visit[r][c] = true;

        if(map[r][c] == 'P') friendCnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && isNotVisit(nr, nc) && isNotWall(nr, nc)) {
                findFriends(nr, nc);
            }
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isNotWall(int r, int c){
        return map[r][c] != 'X';
    }

}
