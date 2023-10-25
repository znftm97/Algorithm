package com.company.v2.프로그래머스.알고.LV3;

public class 미로탈출명령어 {
    static int R,C;
    static String result = "impossible";
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    static String[] dirs = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        R = n;
        C = m;
        int minDistance = Math.abs(x - r) + Math.abs(y - c);

        if(minDistance > k || (k - minDistance) % 2 == 1) {
            return "impossible";
        }

        dfs(0, x, y, r, c, k, new StringBuilder());

        return result;
    }

    static void dfs(int distance, int nowR, int nowC, int endR, int endC, int k, StringBuilder sb) {
        if(k < distance + Math.abs(nowR - endR) + Math.abs(nowC - endC)) {
            return;
        }

        if(distance == k && nowR == endR && nowC == endC) {
            result = sb.toString();
            return;
        }

        for(int i = 0; i<4; i++) {
            int nr = nowR + dr[i];
            int nc = nowC + dc[i];
            String dir = dirs[i];

            if(isInArea(nr, nc) && result.equals("impossible")) {
                dfs(distance + 1, nr, nc, endR, endC, k, sb.append(dir));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static boolean isInArea(int r, int c) {
        return r>=1 && c>=1 && r<=R && c<=C;
    }
}
