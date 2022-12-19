package com.company.v1.백준.최단경로알고리즘.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가제달지_4485 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N;
    private static int index = 1;
    private static StringBuilder sb = new StringBuilder();

    private static class Node implements Comparable<Node>{
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            map = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs();
        }

        System.out.println(sb);
    }

    private static void bfs(){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.r == N - 1 && node.c == N - 1) {
                sb.append("Problem ").append(index++).append(": ").append(node.cost).append("\n");
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (isAbleArea(nr, nc) && isNotVisit(nr, nc)) {
                    visit[nr][nc] = true;
                    pq.add(new Node(nr, nc, node.cost + map[nr][nc]));
                }
            }
        }
    }

    private static boolean isAbleArea(int nr, int nc){
        return nr < N && nc < N && nr >= 0 && nc >=0;
    }

    private static boolean isNotVisit(int nr, int nc){
        return !visit[nr][nc];
    }

}
