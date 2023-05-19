package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10971 {
    private static int minCost = Integer.MAX_VALUE;
    private static int[][] graph;
    private static int[] cities;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        cities = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, N);
        System.out.println(minCost);
    }

    private static void recursion(int depth, int N) {
        if (depth == N) {
            minCost = Math.min(minCost, calculateCost());
        }

        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            cities[depth] = i;
            recursion(depth + 1, N);
            visit[i] = false;
            cities[depth] = 0;
        }
    }

    private static int calculateCost() {
        int sum = 0;
        for (int i = 0; i < cities.length - 1; i++) {
            int cost = graph[cities[i]][cities[i + 1]];
            if (cost == 0) {
                return Integer.MAX_VALUE;
            }
            sum += cost;
        }

        int cost = graph[cities[cities.length - 1]][cities[0]];
        if (cost == 0) {
            return Integer.MAX_VALUE;
        }
        sum += cost;
        return sum;
    }
}
