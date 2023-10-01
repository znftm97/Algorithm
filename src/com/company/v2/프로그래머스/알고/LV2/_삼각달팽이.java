package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class _삼각달팽이 {
    public List<Integer> solution(int n) {
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        int[][] arr = new int[n][n];
        int num = 1;
        int r = 0, c = 0, dir = 0;

        while(true) {
            if(!isInArea(r,c,n) || arr[r][c] != 0) {
                break;
            }

            arr[r][c] = num++;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(isInArea(nr,nc,n) && arr[nr][nc] == 0) {
                r = nr;
                c = nc;
            } else {
                dir++;
                dir %= 3;
                r += dr[dir];
                c += dc[dir];
            }
        }

        List<Integer> results = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(arr[i][j] != 0) results.add(arr[i][j]);
            }
        }

        return results;
    }

    static boolean isInArea(int r, int c, int n) {
        return r>=0 && c>= 0 && r<n && c<n;
    }
}
