package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4179 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited, fireVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Node> personQ = new LinkedList<>();
    static Queue<Node> fireQ = new LinkedList<>();

    static class Node {
        int r,c,time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        fireVisited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = s.charAt(c);
                if(map[r][c] == 'J') personQ.add(new Node(r, c, 0));
                else if(map[r][c] == 'F') fireQ.add(new Node(r, c, 0));
            }
        }

        while (true) {
            spreadFire();
            move();
        }
    }

    static void move() {
        if (personQ.isEmpty()) { // 더이상 이동할 공간이 없음
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }

        Queue<Node> q = new LinkedList<>(personQ);
        personQ.clear();

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.r][node.c] = true;

            if(isSide(node)) {
                System.out.println(node.time + 1);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (isInArea(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                    personQ.add(new Node(nr, nc, node.time + 1));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    static void spreadFire() {
        Queue<Node> q = new LinkedList<>(fireQ);
        fireQ.clear();

        while (!q.isEmpty()) {
            Node node = q.poll();
            fireVisited[node.r][node.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (isInArea(nr, nc) && !fireVisited[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'J')) {
                    fireQ.add(new Node(nr, nc, 0));
                    fireVisited[nr][nc] = true;
                    map[nr][nc] = 'F';
                }
            }
        }
    }

    static boolean isSide(Node node) {
        for (int i = 0; i < 4; i++) {
            int nr = node.r + dr[i];
            int nc = node.c + dc[i];

            if (!isInArea(nr, nc)) {
                return true;
            }
        }

        return false;
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
