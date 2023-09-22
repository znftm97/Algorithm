package com.company.v2.프로그래머스.알고.LV2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 거리두기확인하기 {
    static char[][] map;
    static final int N = 5;

    static class Node {
        int r,c;
        public Node(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }

    public int[] solution(String[][] places) {
        int[] results = new int[N];

        for(int i = 0; i<N; i++) {
            map = new char[N][N];
            List<Node> people = new ArrayList<>();

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = places[i][r].charAt(c);
                    if(map[r][c] == 'P') people.add(new Node(r,c));
                }
            }

            boolean isKeepDistance = true;
            for(Node node : people) {
                isKeepDistance = bfs(node);
                if(!isKeepDistance) break;
            }

            if(!isKeepDistance) results[i] = 0;
            else results[i] = 1;
        }

        return results;
    }

    static boolean bfs(Node node) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        visited[node.r][node.c] = true;

        for(int i = 0; i<4; i++) {
            int nr = node.r + dr[i];
            int nc = node.c + dc[i];

            if(isInArea(nr, nc)) {
                if(map[nr][nc] == 'P') return false;
                else if(map[nr][nc] == 'O') {
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        for(Node now : q) {
            for(int i = 0; i<4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(isInArea(nr, nc) && !visited[nr][nc] && map[nr][nc] == 'P') {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isInArea(int r,int c) {
        return r>=0 && c>=0 && r<N && c<N;
    }
}
