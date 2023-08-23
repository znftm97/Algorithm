package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _10026_인접리스트 {
    static int N;
    static List<List<Character>> graph = new ArrayList<>();
    static boolean[][] visited;

    static class Point {
        int r,c;
        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];

        for(int r = 0; r<N; r++) {
            graph.add(new ArrayList<>());
        }

        for(int r = 0; r<N; r++) {
            String s = br.readLine();
            for(int c = 0; c<N; c++) {
                graph.get(r).add(s.charAt(c));
            }
        }

        int rgbAreaCnt = 0;
        for(int r = 0; r<N; r++) {
            for(int c = 0; c<N; c++) {
                if(!visited[r][c]) {
                    bfs(r,c);
                    rgbAreaCnt++;
                }
            }
        }

        for(int r = 0; r<N; r++) {
            for(int c = 0; c<N; c++) {
                if(graph.get(r).get(c) == 'R') graph.get(r).set(c, 'G');
            }
        }

        visited = new boolean[N][N];
        int gbAreaCnt = 0;
        for(int r = 0; r<N; r++) {
            for(int c = 0; c<N; c++) {
                if(!visited[r][c]) {
                    bfs(r,c);
                    gbAreaCnt++;
                }
            }
        }

        System.out.println(rgbAreaCnt + " " + gbAreaCnt);
    }

    static void bfs(int r,int c) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[r][c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i<4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (isInArea(nr, nc) && isNotVisit(nr, nc) && equalsColor(p, nr, nc)) {
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static boolean isInArea(int r,int c) {
        return r>=0 && c>=0 && r<N && c<N;
    }

    static boolean isNotVisit(int r,int c) {
        return !visited[r][c];
    }

    static boolean equalsColor(Point p, int r, int c){
        return graph.get(p.r).get(p.c) == graph.get(r).get(c);
    }
}
