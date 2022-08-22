package com.company.v1.백준.최단경로알고리즘.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서강그라운드_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 1000000;

        int nodeCnt = Integer.parseInt(st.nextToken());
        int searchScope = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        int[][] map = new int[nodeCnt + 1][nodeCnt + 1];
        int[] itemCounts = new int[nodeCnt + 1];

        for (int i = 1; i <= nodeCnt; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                if(i != j) map[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeCnt; i++) {
            itemCounts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[x][y] = cost;
            map[y][x] = cost;
        }

        for (int k = 1; k <= nodeCnt; k++) {
            for (int i = 1; i <= nodeCnt; i++) {
                for (int j = 1; j <= nodeCnt; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= nodeCnt; i++) {
            int sum = itemCounts[i];
            for (int j = 1; j <= nodeCnt; j++) {
                if(i == j) continue;
                if(map[i][j] <= searchScope) sum += itemCounts[j];
            }

            result = Math.max(result, sum);
        }

        System.out.println(result);
    }

}
