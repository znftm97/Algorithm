package com.company.v2.프로그래머스.알고.LV2;

public class 행렬테두리회전하기 {
    private static int[] results;
    private static int[][] map;
    private static int min = Integer.MAX_VALUE;

    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows + 1][columns + 1];
        results = new int[queries.length];
        int num = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            results[i] = rotate(r1, c1, r2, c2);
        }

        return results;
    }

    private static int rotate(int r1, int c1, int r2, int c2) {
        int moveC = c2 - c1;
        int moveR = r2 - r1;
        int beforeVal = map[r1][c1];
        int nowR = r1;
        int nowC = c1;
        min = beforeVal;

        // 오른쪽 이동
        for (int i = 0; i < moveC; i++) {
            nowC++;
            beforeVal = move(nowR, nowC, beforeVal);
        }

        // 아래로 이동
        for (int i = 0; i < moveR; i++) {
            nowR++;
            beforeVal = move(nowR, nowC, beforeVal);
        }

        // 왼쪽 이동
        for (int i = 0; i < moveC; i++) {
            nowC--;
            beforeVal = move(nowR, nowC, beforeVal);
        }

        // 위쪽 이동
        for (int i = 0; i < moveR; i++) {
            nowR--;
            beforeVal = move(nowR, nowC, beforeVal);
        }

        return min;
    }

    private static int move(int nowR, int nowC, int beforeVal) {
        int afterVal = map[nowR][nowC];
        map[nowR][nowC] = beforeVal;

        min = Math.min(min, afterVal);

        return afterVal;
    }

}
