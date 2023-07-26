package com.company.v2.릿코드.알고리즘.medium;

public class _59 {
    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        map[0][0] = 1;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0;
        int c = 0;
        int dir = 0;
        int num = 2;
        while (num <= n * n) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(isChangeDir(map, nr, nc, n)) {
                dir++;
                dir %= 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            map[nr][nc] = num++;
            r = nr;
            c = nc;
        }

        return map;
    }

    private boolean isChangeDir(int[][] map, int r, int c, int n) {
        return !(r >= 0 && c >= 0 && r < n && c < n) || map[r][c] != 0;
    }
}
