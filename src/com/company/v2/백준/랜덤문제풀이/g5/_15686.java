package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {
    private static final int HOUSE = 1;
    private static final int CHICKEN_HOUSE = 2;
    private static List<Point> houses = new ArrayList<>();
    private static List<Point> chickenHouses = new ArrayList<>();
    private static int N, targetChickenHouseCnt;
    private static int minDistance = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] selectChickenHouses;

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
        N = Integer.parseInt(st.nextToken());
        targetChickenHouseCnt = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                switch (map[r][c]) {
                    case HOUSE -> houses.add(new Point(r, c));
                    case CHICKEN_HOUSE -> chickenHouses.add(new Point(r, c));
                }
            }
        }

        selectChickenHouses = new boolean[chickenHouses.size() + 1];
        recursion(0, 0);
        System.out.println(minDistance);
    }

    private static void recursion(int depth, int start) {
        if (depth == targetChickenHouseCnt) {
            minDistance = Math.min(minDistance, calculateDistance());
            return;
        }

        for (int i = start; i < chickenHouses.size(); i++) {
            selectChickenHouses[i] = true;
            recursion(depth + 1, i + 1);
            selectChickenHouses[i] = false;
        }
    }

    private static int calculateDistance() {
        int totalDistance = 0;

        for (int i = 0; i < houses.size(); i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < chickenHouses.size(); j++) {
                if (selectChickenHouses[j]) {
                    int distance = Math.abs(houses.get(i).r - chickenHouses.get(j).r) + Math.abs(houses.get(i).c - chickenHouses.get(j).c);
                    min = Math.min(min, distance);
                }
            }

            totalDistance += min;
        }

        return totalDistance;
    }
}
