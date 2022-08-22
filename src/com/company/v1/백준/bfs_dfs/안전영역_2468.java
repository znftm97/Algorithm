package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역_2468 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxHeight = 0;
        int maxSafeArea = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        for (int h = 0; h < maxHeight; h++) {
            int safeArea = 0;
            visit = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] > h && !visit[i][j]){
                        bfs(i, j, h);
                        safeArea++;
                    }
                }
            }

            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        System.out.println(maxSafeArea);
        br.close();
    }

    public static void bfs(int r, int c, int height) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();

        qr.add(r);
        qc.add(c);
        visit[r][c] = true;

        while (!qr.isEmpty() && !qc.isEmpty()) {
            r = qr.poll();
            c = qc.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;

                if (notEscape(nr, nc) && notVisit(nr, nc) && isSafe(nr, nc, height)) {
                    qr.add(nr);
                    qc.add(nc);
                    visit[nr][nc] = true;
                }
            }
        }
    }

    public static boolean notEscape(int nr, int nc){
        if(nr >= 0 && nc >= 0 && nr < n && nc < n){
            return true;
        }

        return false;
    }

    public static boolean notVisit(int nr, int nc){
        if (!visit[nr][nc]) {
            return true;
        }

        return false;
    }

    public static boolean isSafe(int nr, int nc, int height){
        if (map[nr][nc] > height) {
            return true;
        }

        return false;
    }
}
