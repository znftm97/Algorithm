package com.company.백준.최단경로알고리즘.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 친구_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 250000000;

        int nodeCnt = Integer.parseInt(br.readLine());
        int[][] map = new int[nodeCnt][nodeCnt];

        for (int i = 0; i < nodeCnt; i++) {
            for (int j = 0; j < nodeCnt; j++) {
                if(i != j) map[i][j] = INF;
            }
        }

        for (int i = 0; i < nodeCnt; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < nodeCnt; j++) {
                if(split[j].equals("Y")) map[i][j] = 1;
            }
        }

        for (int k = 0; k < nodeCnt; k++) {
            for (int i = 0; i < nodeCnt; i++) {
                for (int j = 0; j < nodeCnt; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < nodeCnt; i++) {
            int max = 0;
            for (int j = 0; j < nodeCnt; j++) {
                if(i==j) continue;
                if(map[i][j] <= 2) max++;
            }

            result = Math.max(result, max);
        }

        System.out.println(result);
    }

}
