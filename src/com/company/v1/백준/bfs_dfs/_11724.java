package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11724 {
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        count = 0;
        for (int i = 1; i <= N; i++) {
            if (check[i] == true) {
                continue;
            }

            DFS(i);
            count++;
        }

        System.out.println(count);
    }

    static void DFS(int start) {
        if (check[start] == true) {
            return;
        }
        check[start] = true;

        for (int x : list[start]) {
            if (!check[x]) {
                DFS(x);
            }
        }
    }
}
