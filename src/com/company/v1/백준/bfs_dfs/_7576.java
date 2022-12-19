package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy= {-1, 1, 0, 0};
    private static int mapSizeX, mapSizeY;
    private static int[][] map;

    private static int bfs(Queue<Node> q) {
        int day = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            day = node.getDay();

            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];

                if (0 <= nx && nx < mapSizeX && 0 <= ny && ny < mapSizeY) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        q.offer(new Node(nx, ny, day+1));
                    }
                }
            }
        }

        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSizeY = Integer.parseInt(st.nextToken());
        mapSizeX = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        map = new int[mapSizeX][mapSizeY];

        for (int i = 0; i < mapSizeX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSizeY; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Node(i, j, 0));
                }
            }
        }

        System.out.println(bfs(q));
    }
}

class Node {
    public int x;
    public int y;
    public int day;

    public Node(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getDay() { return day; }
}
