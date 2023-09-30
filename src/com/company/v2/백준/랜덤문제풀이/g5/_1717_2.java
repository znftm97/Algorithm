package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717_2 {
    static int[] parents;
    static int[] ranks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        ranks = new int[N + 1];

        for(int i = 0; i<=N; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(command == 0) {
                union(x,y);
            } else {
                x = find(x);
                y = find(y);

                if(x == y) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if(parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(ranks[x] > ranks[y]) parents[x] = y;
        else parents[y] = x;

        if(ranks[x] == ranks[y]) ranks[x]++;
    }
}
