package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10451 {
    static int N;
    static int[] parents, ranks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N + 1];
            ranks = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }

            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                int y = Integer.parseInt(st.nextToken());

                if(find(x) == find(y)) {
                    result++;
                } else {
                    union(x, y);
                }
            }

            System.out.println(result);
        }
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
