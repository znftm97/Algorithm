package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717 {

    private static int[] parents;
    private static int[] rank;
    private static final int UNION = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (operation == UNION) {
                union(x, y);
                continue;
            }

            if(find(x) == find(y)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y) return;

        if(rank[x] < rank[y]) parents[y] = x;
        else parents[x] = y;

        if(rank[x] == rank[y]) rank[x]++;
    }

    private static int find(int x) {
        if(x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }
}
