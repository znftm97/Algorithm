package com.company.v1.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙빙돌며숫자사각형채우기2 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int num = 1;
        int r = 0;
        int c = 0;
        int dir = 0;

        while (num <= N * M) {
            map[r][c] = num++;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isChangeDirection(nr, nc)) {
                dir++;
                if (dir == 4) {
                    dir = 0;
                }

                r += dr[dir];
                c += dc[dir];
            } else {
                r = nr;
                c = nc;
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isChangeDirection(int r, int c) {
        if (isAbleArea(r, c) && map[r][c] == 0) {
            return false;
        }

        return true;
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

}
