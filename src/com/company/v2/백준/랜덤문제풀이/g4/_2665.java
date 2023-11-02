package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2665 {
    static final char BLACK = '0';
    static final char WHITE = '1';
    static int N;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Node implements Comparable<Node>{
        int r,c,color,cost;

        public Node (int r, int c, int color, int cost) {
            this.r=r;
            this.c=c;
            this.color = color;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N*N][N][N];

        for(int r = 0; r<N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        bfs();
    }

    static void bfs() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,WHITE,0));
        visited[0][0][0] = true;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.r == N - 1 && now.c == N - 1) {
                System.out.println(now.cost);
                System.exit(0);
            }

            for(int i = 0; i<4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (!isInArea(nr, nc)) {
                    continue;
                }

                if (map[nr][nc] == WHITE && !visited[now.cost][nr][nc]) {
                    pq.add(new Node(nr, nc, WHITE, now.cost));
                    visited[now.cost][nr][nc] = true;
                } else if (map[nr][nc] == BLACK && !visited[now.cost + 1][nr][nc]) {
                    pq.add(new Node(nr, nc, BLACK, now.cost + 1));
                    visited[now.cost + 1][nr][nc] = true;
                }
            }
        }
    }

    static boolean isInArea(int r, int c) {
        return r>=0 && c>=0 && r<N && c<N;
    }
}
