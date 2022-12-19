package com.company.v1.백준.최단경로알고리즘.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = 5001;
        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int[][] map = new int[nodeCnt + 1][nodeCnt + 1];

        for (int i = 1; i <= nodeCnt; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                if(i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

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

        int result = 0;
        int min = INF;
        for (int i = nodeCnt; i > 0; i--) { // 번호가 가장 작은 사람을 출력하기 위해 반대로
            int sum = 0;

            for (int j = 1; j <= nodeCnt; j++) {
                if(map[i][j] == 0) continue;
                sum += map[i][j];
            }

            if (min >= sum) {
                min = sum;
                result = i;
            }
        }

        System.out.println(result);
    }

}
