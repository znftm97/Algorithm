package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1987_2 {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static Set<Character> visitedAlphabets = new HashSet<>();
    static int result = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        recursion(0, 0, 1);

        System.out.println(result);
    }

    static void recursion(int r, int c, int cnt) {
        if (visitedAlphabets.contains(map[r][c])) {
            result = Math.max(result, cnt - 1);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isInArea(nr, nc)) {
                visitedAlphabets.add(map[r][c]);
                recursion(nr, nc, cnt + 1);
                visitedAlphabets.remove(map[r][c]);
            }
        }
    }

    static boolean isInArea(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
