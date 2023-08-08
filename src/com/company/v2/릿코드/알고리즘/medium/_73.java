package com.company.v2.릿코드.알고리즘.medium;

public class _73 {

    private boolean[][] visited;
    private int R,C;

    public void setZeroes(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 0 && !visited[r][c]) {
                    fillZero(r,c, matrix);
                }
            }
        }
    }

    private void fillZero(int zeroR, int zeroC, int[][] matrix) {
        visited[zeroR][zeroC] = true;

        for (int c = 0; c < C; c++) {
            if(matrix[zeroR][c] == 0) continue;
            matrix[zeroR][c] = 0;
            visited[zeroR][c] = true;
        }

        for (int r = 0; r < R; r++) {
            if(matrix[r][zeroC] == 0) continue;
            matrix[r][zeroC] = 0;
            visited[r][zeroC] = true;
        }
    }
}
