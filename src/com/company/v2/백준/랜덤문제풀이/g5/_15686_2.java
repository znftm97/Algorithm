package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686_2 {
    private static final int HOUSE = 1;
    private static final int CHICKEN_HOUSE = 2;
    private static int[][] map;
    private static boolean[] chickenHouse;
    private static List<Point> houses = new ArrayList<>();
    private static List<Point> chickenHouses = new ArrayList<>();
    private static int minDistance = Integer.MAX_VALUE;

    private static class Point {
        int r, c;
        public Point(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == HOUSE) houses.add(new Point(r, c));
                else if (map[r][c] == CHICKEN_HOUSE) chickenHouses.add(new Point(r, c));
            }
        }

        chickenHouse = new boolean[chickenHouses.size()];
        recursion(0, 0, M);

        System.out.println(minDistance);
    }

    private static void recursion(int depth, int start, int M) {
        if (depth == M) {
            minDistance = Math.min(minDistance, calculateCityDistance());
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            chickenHouse[i] = true;
            recursion(depth + 1, i + 1, M);
            chickenHouse[i] = false;
        }
    }

    private static int calculateCityDistance() {
        int cityDistance = 0;

        for (Point house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickenHouses.size(); i++) {
                if (chickenHouse[i]) {
                    minDistance = Math.min(minDistance, getDistance(house, chickenHouses.get(i)));
                }
            }

            cityDistance += minDistance;
        }

        return cityDistance;
    }

    private static int getDistance(Point house, Point chickenHouse) {
        return Math.abs(house.r - chickenHouse.r) + Math.abs(house.c - chickenHouse.c);
    }
}
