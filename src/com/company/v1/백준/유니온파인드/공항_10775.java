package com.company.v1.백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공항_10775 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gateCount = Integer.parseInt(br.readLine());
        int airplaneCount = Integer.parseInt(br.readLine());
        int count = 0;
        parent = new int[gateCount + 1];

        for (int i = 1; i <= gateCount; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= airplaneCount; i++) {
            int dockingNum = Integer.parseInt(br.readLine());
            int parentNum = find(dockingNum);

            if (parentNum == 0) {
                break;
            }

            count++;
            union(parentNum, parentNum - 1);
        }

        System.out.println(count);

    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}
