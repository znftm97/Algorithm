package com.company.v2.프로그래머스.알고.LV2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 리코쳇로봇 {
    static char[][] map;
    static boolean[][] visited;
    static int R,C,result;

    static class Point implements Comparable<Point> {
        int r,c,dist;

        public Point(int r, int c, int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }

        @Override
        public int compareTo(Point p) {
            return Integer.compare(this.dist, p.dist);
        }
    }

    public int solution(String[] board) {
        R = board.length;
        C = board[0].length();
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i<R; i++) {
            map[i] = board[i].toCharArray();
        }

        for(int r = 0; r<R; r++) {
            for(int c= 0; c<C; c++) {
                if(map[r][c] == 'R') {
                    bfs(r,c);
                }
            }
        }

        return result == 0 ? -1 : result;
    }

    static void bfs(int r, int c) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(r,c,0));
        visited[r][c] = true;

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            if(map[p.r][p.c] == 'G') {
                result = p.dist;
                return;
            }

            for(int i = 0; i<4; i++) {
                int nr = getNr(dr[i], p.r, p.c);
                int nc = getNc(dc[i], p.r, p.c);

                if(isInArea(nr,nc) && canVisit(nr, nc)) {
                    pq.add(new Point(nr, nc, p.dist + 1));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static int getNr(int dir, int r, int c) {
        if(dir == 0) return r;

        while(true) {
            if(!isInArea(r + dir, c) || map[r + dir][c] == 'D') {
                return r;
            }

            r += dir;
        }
    }

    static int getNc(int dir, int r, int c) {
        if(dir == 0) return c;

        while(true) {
            if(!isInArea(r, c + dir) || map[r][c + dir] == 'D') {
                return c;
            }

            c += dir;
        }
    }

    static boolean isInArea(int r, int c) {
        return r>=0 && c>=0 && r<R && c<C;
    }

    static boolean canVisit(int r, int c) {
        return !visited[r][c];
    }
}
