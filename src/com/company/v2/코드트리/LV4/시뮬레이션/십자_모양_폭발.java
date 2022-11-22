package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 십자_모양_폭발 {
    private static final int BOOM = -1;
    private static int N, bombR, bombC;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        bombR = Integer.parseInt(st.nextToken()) - 1;
        bombC = Integer.parseInt(st.nextToken()) - 1;
        int range = map[bombR][bombC];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (isSameRC(r, c) && isInRange(r, c, range)) {
                    map[r][c] = BOOM;
                }
            }
        }

        int[][] tmp = new int[N][N];
        for (int c = 0; c < N; c++) {
            int nr = N - 1;
            for (int r = N - 1; r >= 0; r--) {
                if (map[r][c] != BOOM) {
                    tmp[nr--][c] = map[r][c];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            map[i] = tmp[i].clone();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isSameRC(int r, int c) {
        return r == bombR || c == bombC;
    }

    private static boolean isInRange(int r, int c, int range) {
        return Math.abs(r - bombR) + Math.abs(c - bombC) < range;
    }

}
