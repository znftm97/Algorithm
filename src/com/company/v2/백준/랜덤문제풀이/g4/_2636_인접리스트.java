package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2636_인접리스트 {
    static int R, C, cheese;
    static final int CHEESE = 1;
    static final int EMPTY = 0;
    static List<List<Point>> graph = new ArrayList<>();

    static class Point {
        int r,c,value;
        public Point(int r,int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            graph.add(new ArrayList<>());
            for (int c = 0; c < C; c++) {
                int value = Integer.parseInt(st.nextToken());
                graph.get(r).add(new Point(r, c, value));
                if(value == CHEESE) cheese++;
            }
        }

        int lastCheese = 0;
        int time = 0;
        while (cheese > 0) {
            lastCheese = cheese;
            bfs();
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        q.add(new Point(0, 0, graph.get(0).get(0).value));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && isNotVisit(nr, nc, visited)) {
                    visited[nr][nc] = true;
                    if (isCheese(nr, nc)) {
                        graph.get(nr).get(nc).value = EMPTY;
                        cheese--;
                    } else {
                        q.add(new Point(nr, nc, EMPTY));
                    }
                }
            }
        }
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    static boolean isNotVisit(int r, int c, boolean[][] visited) {
        return !visited[r][c];
    }

    static boolean isCheese(int r, int c) {
        return graph.get(r).get(c).value == CHEESE;
    }
}
