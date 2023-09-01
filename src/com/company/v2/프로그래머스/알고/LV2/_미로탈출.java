package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class _미로탈출 {
    static char[][] map;
    static boolean[][] visited;
    static int R,C,result;

    static class Point implements Comparable<Point>{
        int r,c,time;
        public Point(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time = time;
        }

        @Override
        public int compareTo(Point p) {
            return Integer.compare(this.time, p.time);
        }
    }

    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];

        Point button = null;
        Point end = null;
        Point start = null;;
        for(int r = 0; r<R; r++) {
            for(int c = 0; c<C; c++) {
                map[r][c] = maps[r].charAt(c);
                if(map[r][c] == 'L') button = new Point(r,c,0);
                else if(map[r][c] == 'E') end = new Point(r,c,0);
                else if(map[r][c] == 'S') start = new Point(r,c,0);
            }
        }

        if(!bfs(start, button)) return -1;
        if(!bfs(button, end)) return -1;

        return result;
    }

    static boolean bfs(Point start, Point end) {
        visited = new boolean[R][C];
        int[] dr = {-1,1,0,0,};
        int[] dc = {0,0,-1,1};
        Queue<Point> pq = new PriorityQueue<>();
        pq.add(start);

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            if(p.r == end.r && p.c == end.c) {
                result += p.time;
                return true;
            }

            for(int i = 0; i<4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(isInArea(nr, nc) && canVisit(nr, nc) && map[nr][nc] != 'X') {
                    pq.add(new Point(nr, nc, p.time + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        return false;
    }

    static boolean isInArea(int r, int c) {
        return r>=0 && c>=0 && r<R && c<C;
    }

    static boolean canVisit(int r, int c) {
        return !visited[r][c];
    }
}
