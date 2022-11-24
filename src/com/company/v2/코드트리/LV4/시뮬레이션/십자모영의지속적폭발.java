package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 십자모영의지속적폭발 {
    private static final int NONE = 0;
    private static int N, M, bombR, bombC;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int T = 0; T < M; T++) {
            bombC = Integer.parseInt(br.readLine()) - 1;
            bombR = 0;

            if (!findBoom()) {
                continue;
            }

            boom();
            drop();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean findBoom() {
        for (int r = 0; r < N; r++) {
            if (isBoom(r, bombC)) {
                bombR = r;
                return true;
            }
        }

        return false;
    }

    private static void boom() {
        int range = map[bombR][bombC];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (isSameRC(r, c) && isInRange(r, c, range)) {
                    map[r][c] = NONE;
                }
            }
        }
    }

    private static void drop() {
        int[][] tmp = new int[N][N];

        for (int c = 0; c < N; c++) {
            int nr = N - 1;
            for (int r = N - 1; r >= 0; r--) {
                if (map[r][c] != NONE) {
                    tmp[nr--][c] = map[r][c];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            map[i] = tmp[i].clone();
        }
    }

    private static boolean isBoom(int r, int c) {
        return map[r][c] != 0;
    }

    private static boolean isSameRC(int r, int c) {
        return r == bombR || c == bombC;
    }

    private static boolean isInRange(int r, int c, int range) {
        return Math.abs(r - bombR) + Math.abs(c - bombC) < range;
    }
}
