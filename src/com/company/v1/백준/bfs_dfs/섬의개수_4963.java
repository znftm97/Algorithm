package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수_4963 {
    static int[][] map;
    static int N,M;
    static int islandCount = 0;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = { 0, 0, 1, -1, 1, 1, -1, -1};

    static class islandPoint {
        int x;
        int y;

        public islandPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public void bfs(int x, int y) {
        Queue<islandPoint> q = new LinkedList<>();
        q.add(new islandPoint(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            islandPoint poll = q.poll();
            x = poll.x;
            y = poll.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new islandPoint(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            map = new int[N][M];
            visit = new boolean[N][M];

            /*지도 입력*/
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            /*섬 찾기*/
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        islandCount++;
                        bfs(i,j);
                    }
                }
            }

            sb.append(islandCount).append("\n");
            islandCount = 0;
        }

        System.out.println(sb.toString());
    }
}
