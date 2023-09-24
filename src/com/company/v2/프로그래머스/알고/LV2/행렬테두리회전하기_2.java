package com.company.v2.프로그래머스.알고.LV2;

public class 행렬테두리회전하기_2 {
    static int R,C;
    static int[][] originMap;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public int[] solution(int rows, int columns, int[][] queries) {
        R = rows;
        C = columns;
        int[] results = new int[queries.length];
        originMap = new int[R + 1][C + 1];
        map = new int[R + 1][C + 1];

        int num = 1;
        for(int r = 1; r<=R; r++) {
            for(int c= 1; c<=C; c++) {
                originMap[r][c] = num;
                map[r][c] = num++;
            }
        }

        for(int i = 0; i<queries.length; i++) {
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            rotate(r1,c1,r2,c2);

            results[i] = min;
            min = Integer.MAX_VALUE;
            copyMap();
        }

        return results;
    }

    static void copyMap() {
        for(int r= 1; r<=R; r++) {
            originMap[r] = map[r].clone();
        }
    }

    static void rotate(int r1, int c1, int r2, int c2) {
        right(r1,c1,r2,c2);
        down(r1,c1,r2,c2);
        left(r1,c1,r2,c2);
        up(r1,c1,r2,c2);
    }

    static void right(int r1, int c1, int r2, int c2) {
        int range = c2 - c1;
        for(int i = 0; i < range; i++) {
            int before = originMap[r1][c1];
            min = Math.min(min, before);
            map[r1][c1 + 1] = before;
            c1++;
        }
    }

    static void down(int r1, int c1, int r2, int c2) {
        int range = r2 - r1;
        for(int i = 0; i < range; i++) {
            int before = originMap[r1][c2];
            min = Math.min(min, before);
            map[r1+1][c2] = before;
            r1++;
        }
    }

    static void left(int r1, int c1, int r2, int c2) {
        int range = c2 - c1;
        for(int i = 0; i < range; i++) {
            int before = originMap[r2][c2];
            min = Math.min(min, before);
            map[r2][c2-1] = before;
            c2--;
        }
    }

    static void up(int r1, int c1, int r2, int c2) {
        int range = r2 - r1;
        for(int i = 0; i < range; i++) {
            int before = originMap[r2][c1];
            min = Math.min(min, before);
            map[r2 - 1][c1] = before;
            r2--;
        }
    }
}
