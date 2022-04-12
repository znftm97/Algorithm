package com.company.백준.최단경로알고리즘.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟_1261 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int R, C;

    private static class Node implements Comparable<Node>{
        int r;
        int c;
        int wallCnt;

        public Node(int r, int c, int wallCnt) {
            this.r = r;
            this.c = c;
            this.wallCnt = wallCnt;
        }

        @Override
        public int compareTo(Node p) {
            return Integer.compare(this.wallCnt, p.wallCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.r == R - 1 && now.c == C - 1) return now.wallCnt;

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (isAbleArea(nr, nc) && isNotVisit(nr, nc)) {
                    visit[nr][nc] = true;
                    if (map[nr][nc] == 1) pq.add(new Node(nr, nc, now.wallCnt + 1));
                    else pq.add(new Node(nr, nc, now.wallCnt));
                }
            }
        }

        return 0;
    }

    private static boolean isAbleArea(int nr, int nc){
        return nr < R && nc < C && nr >= 0 && nc >=0;
    }

    private static boolean isNotVisit(int nr, int nc){
        return !visit[nr][nc];
    }

}
