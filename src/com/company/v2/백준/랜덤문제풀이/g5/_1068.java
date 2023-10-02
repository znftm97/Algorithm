package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1068 {

    static int[] parents;
    static boolean[] visited;
    static int N, leaf;
    static final int REMOVED_NODE = -10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        visited = new boolean[N];
        int root = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1) root = i;
        }

        int remove = Integer.parseInt(br.readLine());
        remove(remove);
        countLeaf(root);

        System.out.println(leaf);
    }

    static void remove(int remove) {
        parents[remove] = REMOVED_NODE;

        for (int i = 0; i < N; i++) {
            if (parents[i] == remove) {
                parents[i] = REMOVED_NODE;
            }
        }
    }

    static void countLeaf(int parent) {
        boolean isLeaf = true;
        visited[parent] = true;

        if (parents[parent] != REMOVED_NODE) {
            for (int i = 0; i < N; i++) {
                if (parents[i] == parent && !visited[i]) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }

            if(isLeaf) leaf++;
        }
    }
}
