package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18428 {
    static int N;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken();
            }
        }

        recursion(0);
        System.out.println("NO");
    }

    static void recursion(int depth) {
        if (depth == 3) {
            if (canEscape()) {
                System.out.println("YES");
                System.exit(0);
            }

            return;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].equals("X")) {
                    map[r][c] = "O";
                    recursion(depth + 1);
                    map[r][c] = "X";
                }
            }
        }
    }

    static boolean canEscape() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].equals("T")) {
                    if (meetStudent(r, c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static boolean meetStudent(int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c;
            while (true) {
                nr += dr[i];
                nc += dc[i];

                if (!isInArea(nr, nc) || map[nr][nc].equals("O")) {
                    break;
                }

                if (map[nr][nc].equals("S")) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
