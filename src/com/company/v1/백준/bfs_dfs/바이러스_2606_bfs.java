package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_2606_bfs {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerAmount = Integer.parseInt(br.readLine());
        int connectionAmount = Integer.parseInt(br.readLine());
        map = new ArrayList[computerAmount+1];
        visit = new boolean[computerAmount+1];

        for (int i = 1; i <= computerAmount; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectionAmount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        bfs(1);
        System.out.println(result-1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            visit[x] = true;
            result++;

            for (int y : map[x]) {
                if (!visit[y]) {
                    q.add(y);
                    visit[y] = true;
                }
            }
        }
    }
}
