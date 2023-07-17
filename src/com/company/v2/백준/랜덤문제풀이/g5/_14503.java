package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503 {
    private static final int CLEAN = -1;
    private static final int EMPTY = 0;
    private static int[][] map;
    private static int R, C, result;
    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};

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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        st = new StringTokenizer(br.readLine());
        int robotR = Integer.parseInt(st.nextToken());
        int robotC = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        Point robot = new Point(robotR, robotC);

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (map[robot.r][robot.c] == EMPTY) {
                map[robot.r][robot.c] = CLEAN;
                result++;
            }

            if (hasEmptyInAround(robot)) {
                dir -= 1;
                if(dir < 0) dir = 3;

                int nr = robot.r + dr[dir];
                int nc = robot.c + dc[dir];
                if (map[nr][nc] == EMPTY) {
                    robot.r = nr;
                    robot.c = nc;
                }
            } else {
                int backdir = 0;
                if(dir == 0 || dir == 1) backdir = dir + 2;
                else backdir = dir - 2;

                int nr = robot.r + dr[backdir];
                int nc = robot.c + dc[backdir];

                if (isInArea(nr, nc) && map[nr][nc] == EMPTY || map[nr][nc] == CLEAN) {
                    robot.r = nr;
                    robot.c = nc;
                } else {
                    System.out.println(result);
                    return;
                }
            }
        }
    }

    private static boolean hasEmptyInAround(Point robotPoint) {
        for (int i = 0; i < 4; i++) {
            int nr = robotPoint.r + dr[i];
            int nc = robotPoint.c + dc[i];

            if (isInArea(nr,nc) && map[nr][nc] == EMPTY) {
                return true;
            }
        }

        return false;
    }

    private static boolean isInArea(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
