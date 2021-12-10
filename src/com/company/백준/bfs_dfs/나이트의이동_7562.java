package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {

    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }
    }

    static int[][] map;
    static int N;
    static int[] dr = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] dc = {-2, -1, 2, 1, 2, 1, -2, -1};

    public static void bfs(Point startPoint) {
        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);

        while (!q.isEmpty()) {
            Point point = q.poll();
            int r = point.r;
            int c = point.c;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (notEscape(nr, nc) && notVisited(nr, nc)) {
                    q.add(new Point(nr, nc));
                    map[nr][nc] = map[r][c] + 1;
                }
            }
        }

    }

    public static boolean notEscape(int nr, int nc) {
        if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
            return true;
        }

        return false;
    }

    public static boolean notVisited(int nr, int nc) {
        if (map[nr][nc] == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            st = new StringTokenizer(br.readLine());
            Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (startPoint.equals(endPoint)) {
                sb.append(0).append("\n");
                continue;
            }

            bfs(startPoint);
            sb.append(map[endPoint.r][endPoint.c]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
