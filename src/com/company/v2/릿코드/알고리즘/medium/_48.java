package com.company.v2.릿코드.알고리즘.medium;

public class _48 {
    public void rotate(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        //대칭
        for (int r = 0; r < R; r++) {
            for (int c = r; c < C; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }

        //가로 뒤집기
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[r][C - (c + 1)];
                matrix[r][C - (c + 1)] = tmp;
            }
        }
    }
}
