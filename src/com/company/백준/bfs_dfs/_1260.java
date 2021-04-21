package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1260 {
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        check = new boolean[N + 1];
        DFS(V);
        System.out.println();

        check = new boolean[N + 1];
        BFS(V);
        System.out.println();

        br.close();
    }

    private static void DFS(int x) {
        if (check[x]) {
            return;
        }

        System.out.print(x + " ");
        check[x] = true;
        for (int i : list[x]) {
            if (!check[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        check[x] = true;

        while (!q.isEmpty()) {
            int a = q.poll();
            System.out.print(a + " ");
            for (int k : list[a]) {
                if (!check[k]) {
                    q.add(k);
                    check[k] = true;
                }
            }
        }
    }
}
