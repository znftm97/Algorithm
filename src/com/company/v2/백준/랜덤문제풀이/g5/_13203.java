package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13203 {
    private static boolean[] visit;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            recursion(i, 0);
        }
        System.out.println(0);
    }

    private static void recursion(int node, int depth) {
        if (depth == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visit[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            Integer nextNode = graph.get(node).get(i);
            if(visit[nextNode]) continue;
            visit[nextNode] = true;
            recursion(nextNode, depth + 1);
            visit[nextNode] = false;
        }
    }
}
