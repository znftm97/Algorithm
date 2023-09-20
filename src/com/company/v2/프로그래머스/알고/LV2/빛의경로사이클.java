package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 빛의경로사이클 {
    static int R, C;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][][] visit;

    public List<Integer> solution(String[] grid) {
        List<Integer> results = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();
        visit = new boolean[R][C][4];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int k = 0; k < 4; k++) {
                    if (!visit[r][c][k]) {
                        results.add(light(grid, r, c, k));
                    }
                }
            }
        }

        Collections.sort(results);

        return results;
    }

    public int light(String[] grid, int r, int c, int k){
        int cnt = 0;

        while(true){
            if(visit[r][c][k]) break;

            cnt++;
            visit[r][c][k] = true;

            if (grid[r].charAt(c) == 'L') {
                k = k == 0 ? 3 : k - 1;
            } else if (grid[r].charAt(c) == 'R') {
                k = k == 3 ? 0 : k + 1;
            }

            r = (r + dr[k] + R) % R;
            c = (c + dc[k] + C) % C;
        }

        return cnt;
    }
}
