package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20040 {
    static int N, M;
    static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        ranks = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {
                result = i + 1;
                break;
            } else {
                union(x, y);
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (ranks[x] > ranks[y]) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }

        if (ranks[x] == ranks[y]) {
            ranks[x]++;
        }
    }
}
