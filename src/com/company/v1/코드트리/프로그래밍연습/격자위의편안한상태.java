package com.company.v1.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자위의편안한상태 {
    private static final int PAINTING = 1;
    private static int[][] map;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = PAINTING;

            int nearCnt = 0;
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];

                if (isAbleArea(nr, nc) && isPaint(nr, nc)) {
                    nearCnt++;
                }
            }

            if (nearCnt == 3) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isAbleArea(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }

    private static boolean isPaint(int r, int c) {
        return map[r][c] == PAINTING;
    }
}