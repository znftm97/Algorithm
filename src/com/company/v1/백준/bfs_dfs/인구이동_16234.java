package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동_16234 {
    private static List<Point> Union;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static int N, L, R;

    private static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int moveDays = 0;
        while (true) {
            boolean isMove = false;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        int totalPopulation = bfs(i, j);
                        if (Union.size() > 1) {
                            movePopulation(totalPopulation);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) {
                System.out.println(moveDays);
                break;
            } else {
                moveDays++;
            }
        }
    }

    private static int bfs(int r, int c){
        Queue<Point> q = new LinkedList<>();
        Union = new ArrayList<>();

        q.add(new Point(r, c));
        Union.add(new Point(r, c));
        visit[r][c] = true;

        int totalPopulation = map[r][c];
        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];

                if (isAbleArea(nr, nc) && isOpen(point, nr, nc) && isAbleVisit(nr, nc)) {
                    q.add(new Point(nr, nc));
                    Union.add(new Point(nr, nc));
                    totalPopulation += map[nr][nc];
                    visit[nr][nc] = true;
                }
            }
        }

        return totalPopulation;
    }

    private static boolean isAbleArea(int nr, int nc) {
        if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
            return true;
        }

        return false;
    }

    private static boolean isOpen(Point node, int nr, int nc) {
        int gap = Math.abs(map[node.r][node.c] - map[nr][nc]);
        if (L <= gap && gap <= R) {
            return true;
        }

        return false;
    }

    private static boolean isAbleVisit(int nr, int nc) {
        if (!visit[nr][nc]) {
            return true;
        }

        return false;
    }

    private static void movePopulation(int totalPopulation) {
        int average = totalPopulation / Union.size();
        for (Point p : Union) {
            map[p.r][p.c] = average;
        }
    }

}
