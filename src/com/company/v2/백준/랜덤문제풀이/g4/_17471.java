package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17471 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int N;
    static int min = Integer.MAX_VALUE;
    static List<Integer> areas = new ArrayList<>();
    static List<Integer> anotherAreas = new ArrayList<>();
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < N; i++) {
            recursion(0, i, 1);
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void recursion(int depth, int target, int start) {
        if (depth == target) {
            if (canElection()) {
                min = Math.min(min, calculatePeopleDiff());
            }

            return;
        }

        for (int i = start; i <= N; i++) {
            areas.add(i);
            recursion(depth + 1, target, i + 1);
            areas.remove(areas.size() - 1);
        }
    }

    static boolean canElection() {
        anotherAreas = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!areas.contains(i)) {
                anotherAreas.add(i);
            }
        }

        return bfs(areas) && bfs(anotherAreas);
    }

    static boolean bfs(List<Integer> areas) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(areas.get(0));
        visited[areas.get(0)] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int id = q.poll();

            for (int nextId : graph.get(id)) {
                if (!visited[nextId] && areas.contains(nextId)) {
                    visited[nextId] = true;
                    q.add(nextId);
                    cnt++;
                }
            }
        }

        return cnt == areas.size() - 1;
    }

    static int calculatePeopleDiff() {
        int diff = 0;
        for (int id : areas) {
            diff += people[id];
        }

        for (int id : anotherAreas) {
            diff -= people[id];
        }

        return Math.abs(diff);
    }
}
