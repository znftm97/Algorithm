package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
    static class Tomato{
        int h;
        int r;
        int c;

        public Tomato(int h, int r, int c){
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static int r, c, h;
    static Queue<Tomato> q = new LinkedList<>();

    public static void bfs() {
        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            int h = tomato.h;
            int r = tomato.r;
            int c = tomato.c;

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (notEscape(nh, nr, nc) && notRipe(nh, nr, nc)) {
                    q.add(new Tomato(nh, nr, nc));
                    map[nh][nr][nc] = map[h][r][c] + 1;
                }
            }
        }
    }

    public static boolean notEscape(int nh, int nr, int nc){
        if(nh>= 0 && nr >= 0 && nc >= 0 && nh < h && nr < r && nc < c){
            return true;
        }

        return false;
    }

    public static boolean notRipe(int nh, int nr, int nc){
        if (map[nh][nr][nc] == 0) {
            return true;
        }

        return false;
    }

    public static int findMaxDay() {
        int maxDay = -1;

        for(int i = 0; i < h; i++){
            for(int j = 0; j < r; j++){
                for(int k = 0; k < c; k++){
                    if(map[i][j][k] == 0) {
                        return -1;
                    }

                    maxDay = Math.max(maxDay, map[i][j][k]);
                }
            }
        }

        return maxDay - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][r][c];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < c; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        bfs();

        if (findMaxDay() == 1) {
            System.out.println(0);
        } else {
            System.out.println(findMaxDay());
        }
        br.close();
    }
}
