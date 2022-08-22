package com.company.v1.프로그래머스.백트래킹;

public class 쿼드압축후개수세기 {
    private static int zeroCnt, oneCnt;

    public int[] solution(int[][] map) {

        recursion(0, 0, map.length, map);

        int[] result = new int[2];
        result[0] = zeroCnt;
        result[1] = oneCnt;

        return result;
    }

    private static void recursion(int r, int c, int size, int[][] map){
        if(isPassRule(r, c, size, map)){
            if(map[r][c] == 0) zeroCnt++;
            if(map[r][c] == 1) oneCnt++;

            return;
        }

        int nSize = size / 2;

        recursion(r, c, nSize, map);
        recursion(r, c + nSize, nSize, map);

        recursion(r + nSize, c, nSize, map);
        recursion(r + nSize, c + nSize, nSize, map);
    }

    private static boolean isPassRule(int r, int c, int size, int[][] map){
        int num = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(num != map[i][j]) return false;
            }
        }

        return true;
    }

}
