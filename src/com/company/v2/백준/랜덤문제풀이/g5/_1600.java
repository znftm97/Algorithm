package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600 {
    static int[][] map;
    static boolean[][][] visited;
    static int K, R, C;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] horseDr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horseDc = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Node implements Comparable<Node> {
        int r,c,k,dist;
        public Node(int r, int c, int k, int dist) {
            this.r=r;
            this.c=c;
            this.k=k;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.dist, n.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[K + 1][R][C];

        for(int r = 0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c<C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(-1);
    }

    static void bfs() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, K, 0));
        visited[K][0][0] = true;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.r == R - 1 && now.c == C - 1) {
                System.out.println(now.dist);
                System.exit(0);
            }

            for(int i = 0; i<4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if(isInArea(nr, nc) && !visited[now.k][nr][nc] && map[nr][nc] != 1) {
                    visited[now.k][nr][nc] = true;
                    pq.add(new Node(nr, nc, now.k, now.dist + 1));
                }
            }

            if(now.k > 0) {
                for(int i = 0; i<8; i++) {
                    int nr = now.r + horseDr[i];
                    int nc = now.c + horseDc[i];

                    if(isInArea(nr, nc) && !visited[now.k - 1][nr][nc] && map[nr][nc] != 1) {
                        visited[now.k - 1][nr][nc] = true;
                        pq.add(new Node(nr, nc, now.k - 1, now.dist + 1));
                    }
                }
            }
        }
    }

    static boolean isInArea(int r, int c) {
        return r>=0 && c>=0 && r<R && c<C;
    }
}
