package com.company.v1.백준.최단경로알고리즘.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회장뽑기_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int INF = 2500000;

        int nodeCnt = Integer.parseInt(br.readLine());
        int[][] map = new int[nodeCnt + 1][nodeCnt + 1];

        for (int i = 1; i <= nodeCnt; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                if(i != j) map[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == -1) break;

            map[x][y] = 1;
            map[y][x] = 1;
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

        int[] dist = new int[nodeCnt + 1];
        int candidateScore = INF;
        for (int i = 1; i <= nodeCnt; i++) {
            int max = 0; // 각 노드당, 제일 멀리 있는 노드와의 거리
            for (int j = 1; j <= nodeCnt; j++) {
                max = Math.max(max, map[i][j]);
            }

            dist[i] = max;
            candidateScore = Math.min(candidateScore, dist[i]);
        }

        int candidateCnt = 0;
        for (int num : dist) {
            if(num == candidateScore) candidateCnt++;
        }

        System.out.println(candidateScore + " " + candidateCnt);
        for (int i = 1; i <= nodeCnt; i++) {
            if(dist[i] == candidateScore) System.out.print(i + " ");
        }
    }

}
