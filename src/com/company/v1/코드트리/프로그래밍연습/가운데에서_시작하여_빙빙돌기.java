package com.company.v1.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가운데에서_시작하여_빙빙돌기 {

    private static int N;
    private static int[][] map;
    private static int[] dr = {0, -1, 0, 1};
    private static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int num = 1;
        int r = N / 2;
        int c = N / 2;
        int dir = 0;
        int moveNum = 1;

        while (isAbleArea(r, c)) {

            for (int i = 0; i < moveNum; i++) {
                map[r][c] = num++;

                r += dr[dir];
                c += dc[dir];
            }

            dir++;
            if (dir == 4) {
                dir = 0;
            }

            if (dir == 0 || dir == 2) {
                moveNum++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
