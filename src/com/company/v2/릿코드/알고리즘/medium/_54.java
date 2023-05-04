package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _54 {
    private static int R, C;
    private static boolean[][] visit;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        R = matrix.length;
        C = matrix[0].length;
        visit = new boolean[R][C];

        int r = 0;
        int c = 0;
        int dir = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        result.add(matrix[0][0]);
        visit[0][0] = true;

        while (result.size() < R * C) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isInRange(nr, nc) && isNotVisit(nr, nc)) {
                r = nr;
                c = nc;
                visit[nr][nc] = true;
                result.add(matrix[nr][nc]);
            } else {
                dir++;
                dir %= 4;
            }
        }

        return result;
    }

    private static boolean isInRange(int r, int c) {
        return r < R && c < C && r >= 0 && c >= 0;
    }

    private static boolean isNotVisit(int r, int c) {
        return !visit[r][c];
    }
}
