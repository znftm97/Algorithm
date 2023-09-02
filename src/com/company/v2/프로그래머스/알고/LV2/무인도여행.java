package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 무인도여행 {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;

    static class Point {
        int r,c;
        public Point(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }

    public List<Integer> solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];
        visited = new boolean[R][C];
        List<Integer> results = new ArrayList<>();

        for(int i = 0; i<R; i++) {
            map[i] = maps[i].toCharArray();
        }

        for(int r = 0; r<R; r++) {
            for(int c = 0; c<C; c++) {
                if(!visited[r][c] && map[r][c] != 'X') {
                    results.add(bfs(r,c));
                }
            }
        }

        if(results.isEmpty()) {
            results.add(-1);
            return results;
        }
        Collections.sort(results);

        return results;
    }

    static int bfs(int r, int c) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[r][c] = true;

        int sum = map[r][c] - '0';
        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i<4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(isInArea(nr, nc) && canVisit(nr, nc) && map[nr][nc] != 'X'){
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    sum += map[nr][nc] - '0';
                }
            }
        }

        return sum;
    }

    static boolean isInArea(int r, int c) {
        return r>=0 && c>=0 && r<R && c<C;
    }

    static boolean canVisit(int r, int c) {
        return !visited[r][c];
    }
}
