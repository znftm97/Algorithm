package com.company.v1.백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방청소_10775 {
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int alcohol = Integer.parseInt(st.nextToken());
        int drawer = Integer.parseInt(st.nextToken());
        parent = new int[drawer + 1];
        boolean[] check = new boolean[drawer + 1]; // 서랍에 술이 들어있는지 체크

        for (int i = 1; i <= drawer; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < alcohol; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!check[a]) {                // a번 서랍이 비어있는 경우
                check[a] = true;
                union(a, b);
            } else if(!check[b]) {          // b번 서랍이 비어있는 경우
                check[b] = true;
                union(b, a);
            } else if (!check[find(a)]) {   // a번 서랍의 부모 서랍이 비어있는 경우
                check[find(a)] = true;
                union(a, b);
            } else if (!check[find(b)]) {   // b번 서랍의 부모 서랍이 비어있는 경우
                check[find(b)] = true;
                union(b, a);
            } else {                        // 위 네 조건을 모두 만족하지 않으면 서랍에 술을 보관 불가
                sb.append("SMECE").append("\n");
            }

        }

        System.out.println(sb);

    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[x] = y;
        sb.append("LADICA").append("\n");
    }
}
