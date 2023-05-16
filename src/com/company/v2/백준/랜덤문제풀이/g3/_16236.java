package com.company.v2.백준.랜덤문제풀이.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16236 {
    private static final int SHARK = 9;
    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int time = 0;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static class Point{
        int r, c, distance, sharkSize, ateFishCnt;

        public Point() {}

        public Point(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.sharkSize = 2;
        }

        public void eat() {
            map[this.r][this.c] = 0;
            this.ateFishCnt++;
            if (isSizeUp()) {
                sizeUp();
            }
        }

        private boolean isSizeUp() {
            return this.sharkSize == this.ateFishCnt;
        }

        private void sizeUp() {
            this.sharkSize++;
            this.ateFishCnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Point sharkPoint = new Point();

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == SHARK) sharkPoint = new Point(r, c, 0);
            }
        }

        bfs(sharkPoint);
        System.out.println(time);
    }

    private static void bfs(Point sharkPoint) {
        while (true) {
            Point fishPoint = getMinDistanceFish(sharkPoint);

            if (fishPoint == null) {
                return;
            }

            time += fishPoint.distance;
            map[sharkPoint.r][sharkPoint.c] = 0;
            sharkPoint.r = fishPoint.r;
            sharkPoint.c = fishPoint.c;
            sharkPoint.eat();
        }
    }

    private static Point getMinDistanceFish(Point sharkPoint) {
        Queue<Point> q = new LinkedList<>();
        List<Point> eatableFish = new ArrayList<>();
        visit = new boolean[N][N];
        q.add(sharkPoint);
        visit[sharkPoint.r][sharkPoint.c] = true;

        while (!q.isEmpty()) {
            Point nowP = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = nowP.r + dr[i];
                int nc = nowP.c + dc[i];

                if (isInArea(nr, nc) && canVisit(nr, nc) && isSmallerOrEqualThanShark(nr, nc, sharkPoint.sharkSize)) {
                    Point nextP = new Point(nr, nc, nowP.distance + 1);
                    visit[nr][nc] = true;

                    if(map[nr][nc] == 0 || map[nr][nc] == sharkPoint.sharkSize) q.add(nextP);
                    else if(map[nr][nc] < sharkPoint.sharkSize) eatableFish.add(nextP);
                }
            }
        }

        if(eatableFish.isEmpty()) return null;
        return getNearestFish(eatableFish);
    }

    private static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static boolean canVisit(int r, int c) {
        return !visit[r][c];
    }

    private static boolean isSmallerOrEqualThanShark(int r, int c, int sharkSize) {
        return sharkSize >= map[r][c];
    }

    private static Point getNearestFish(List<Point> eatableFish) {
        eatableFish.sort((o1, o2) -> {
            if(o1.distance != o2.distance) return Integer.compare(o1.distance, o2.distance); // 제일 가까운
            else if(o1.r != o2.r) return Integer.compare(o1.r, o2.r); // 제일 위쪽
            return Integer.compare(o1.c, o2.c); // 제일 왼쪽
        });

        return eatableFish.get(0);
    }
}
