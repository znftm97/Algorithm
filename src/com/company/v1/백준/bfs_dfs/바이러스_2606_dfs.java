package com.company.v1.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스_2606_dfs {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    static int infectionCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int comCount = Integer.parseInt(br.readLine());
        int setCount = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for (int i = 0; i <=comCount; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < setCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        visit = new boolean[comCount + 1];
        dfs(1);

        System.out.println(infectionCount);
        br.close();
    }

    private static void dfs(int start) {
        visit[start] = true;

        for (int i : list.get(start)) {
            if (!visit[i]) {
                infectionCount++;
                dfs(i);
            }
        }
    }
}
