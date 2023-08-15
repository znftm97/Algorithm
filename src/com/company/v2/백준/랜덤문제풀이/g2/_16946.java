package com.company.v2.백준.랜덤문제풀이.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16946 {

    private static Map<Integer, Integer> groupToCntMap = new HashMap<>();
    private static int[][] map;
    private static int groupNum = 10;
    private static final char WALL = 1;
    private static final int EMPTY = 0;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N,M;

    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int r = 0; r<N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == EMPTY) {
                    mapping(r,c);
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == WALL) sb.append(count(r, c) % 10);
                else sb.append(0);
            }

            if (r != N - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void mapping(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        map[r][c] = groupNum;

        int cnt = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i<4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(isInArea(nr, nc) && map[nr][nc] == EMPTY) {
                    q.add(new Point(nr, nc));
                    map[nr][nc] = groupNum;
                    cnt++;
                }
            }
        }

        groupToCntMap.put(groupNum, cnt);
        groupNum++;
    }

    private static int count(int r, int c) {
        Set<Integer> groupNums = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInArea(nr,nc) && map[nr][nc] != WALL) {
                groupNums.add(map[nr][nc]);
            }
        }

        int cnt = 1;
        for (int groupNum : groupNums) {
            cnt += groupToCntMap.get(groupNum);
        }

        return cnt;
    }

    private static boolean isInArea(int r,int c) {
        return r>=0 && c>=0 && r<N && c<M;
    }
}
