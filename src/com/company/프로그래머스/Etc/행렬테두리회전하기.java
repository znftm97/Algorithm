package com.company.프로그래머스.Etc;

public class 행렬테두리회전하기 {
    static int[][] map;
    static int minValue = 0;

    public int[] solution(int rows, int columns, int[][] queries) {

        map = new int[rows + 1][columns + 1];
        int num = 1;
        int[] result = new int[queries.length];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = rotation(queries[i]);
        }

        return result;
    }

    public static int rotation(int[] query) {
        // 직사각형 가로, 세로 각 이동해야할 횟수
        int squareRowCount = query[2] - query[0];
        int squareColCount = query[3] - query[1];

        // 좌표, 좌표값
        int row = query[0];
        int col = query[1];
        int value = map[row][col];

        minValue = value;

        // 위
        for (int i = 0; i < squareColCount; i++) {
            col += 1;
            value = move(row, col, value);
        }

        // 오른쪽
        for (int i = 0; i < squareRowCount; i++) {
            row += 1;
            value = move(row, col, value);
        }

        // 아래
        for (int i = 0; i < squareColCount; i++) {
            col -= 1;
            value = move(row, col, value);
        }

        // 왼쪽
        for (int i = 0; i < squareRowCount; i++) {
            row -= 1;
            value = move(row, col, value);
        }

        return minValue;
    }

    public static int move(int row, int col, int beforeValue) {
        int nextValue = map[row][col];
        minValue = Math.min(minValue, nextValue);
        map[row][col] = beforeValue;

        return nextValue;
    }
}
