package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _11559_2 {
    static final int R = 12;
    static final int C = 6;
    static char[][] map = new char[R][C];
    static boolean[][] visited;

    static class Node {
        int r,c;
        public Node(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int combo = 0;
        while(true) {
            if(boom()) {
                fall();
                combo++;
            } else {
                break;
            }
        }

        System.out.println(combo);
    }

    static boolean boom() {
        visited = new boolean[R][C];
        boolean flag = false;

        for(int r = 0; r<R; r++) {
            for(int c = 0; c<C; c++) {
                if(!visited[r][c] && map[r][c] != '.') {
                    visited[r][c] = true;
                    if(bfs(r,c)) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }

    static boolean bfs(int r, int c) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        List<Node> nodes = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Node startNode = new Node(r, c);
        nodes.add(startNode);
        q.add(startNode);
        int cnt = 1;

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i<4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if(isInArea(nr, nc) && canVisit(nr, nc) && equalsColor(node, nr, nc)) {
                    visited[nr][nc] = true;
                    Node addNode = new Node(nr, nc);
                    q.add(addNode);
                    nodes.add(addNode);
                    cnt++;
                }
            }
        }

        if(cnt >= 4) {
            for(Node n : nodes) {
                map[n.r][n.c] = '.';
            }
            return true;
        }

        return false;
    }

    static boolean isInArea(int r, int c) {
        return r>=0 && c>=0 && r<R && c<C;
    }

    static boolean canVisit(int r, int c) {
        return !visited[r][c];
    }

    static boolean equalsColor(Node node, int r, int c) {
        return map[node.r][node.c] == map[r][c];
    }

    private static void fall() {
        for (int c = 0; c < 6; c++) {
            for (int r = 11; r >= 0; r--) {
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
