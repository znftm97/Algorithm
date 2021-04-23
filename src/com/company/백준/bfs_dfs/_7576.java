package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 1, 0, 0};
        int[] dy= {0, 0, -1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mapSizeX = Integer.parseInt(st.nextToken());
        int mapSizeY = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        int[][] map = new int[mapSizeX][mapSizeY];
        int count = 0, days = 0;

        for (int i = 0; i < mapSizeX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSizeY; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                } else if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        while (count > 0 && !q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cur = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (ny < 0 || nx < 0 || ny >= mapSizeY || nx >= mapSizeX || map[nx][ny] != 0) {
                        continue;
                    }

                    count--;
                    map[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }
            days++;
        }

        System.out.println(count == 0 ? days : -1);
    }
}
