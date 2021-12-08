package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_11807 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static String[][] map;
    static boolean[][] visited;
    static int N;
    static int area = 0;
    static int colorBlindnessArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String colors = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = String.valueOf(colors.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    area++;
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("R")) {
                    map[i][j] = "G";
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    colorBlindnessArea++;
                }
            }
        }

        System.out.println(area + " " + colorBlindnessArea);
        br.close();
    }

    public static void bfs(int r, int c, String color) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        qr.add(r);
        qc.add(c);
        visited[r][c] = true;

        while (!qr.isEmpty() && !qc.isEmpty()) {
            r = qr.poll();
            c = qc.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (notEscape(nr, nc) && notVisit(nr, nc) && equals(nr, nc, color) ) {
                    qr.add(nr);
                    qc.add(nc);
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean notEscape(int nr, int nc){
        if(nr >= 0 && nc >= 0 && nr < N && nc < N){
            return true;
        }

        return false;
    }

    public static boolean notVisit(int nr, int nc){
        if (!visited[nr][nc]) {
            return true;
        }

        return false;
    }

    public static boolean equals(int nr, int nc, String color){
        if (map[nr][nc].equals(color)) {
            return true;
        }

        return false;
    }
}
