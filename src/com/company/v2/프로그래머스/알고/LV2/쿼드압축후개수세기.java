package com.company.v2.프로그래머스.알고.LV2;

public class 쿼드압축후개수세기 {
    static int[] results = new int[2];

    public int[] solution(int[][] arr) {
        recursion(0, 0, arr.length, arr);

        return results;
    }

    static void recursion(int r, int c, int n, int[][] arr) {
        if(equalsNumber(r,c,n,arr)) {
            if(arr[r][c] == 0) results[0]++;
            else results[1]++;

            return;
        }

        n /= 2;
        recursion(r, c, n, arr);
        recursion(r, c+n, n, arr);
        recursion(r+n, c, n, arr);
        recursion(r+n, c+n, n, arr);
    }

    static boolean equalsNumber(int R, int C, int n, int[][] arr) {
        int num = arr[R][C];

        for(int r = R; r< R + n; r++) {
            for(int c = C; c < C + n; c++) {
                if(num != arr[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}
