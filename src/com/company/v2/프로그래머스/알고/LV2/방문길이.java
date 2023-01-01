package com.company.v2.프로그래머스.알고.LV2;

import java.util.HashSet;
import java.util.Set;

public class 방문길이 {

    enum Dir{
        L(0, -1), R(0, 1), U(-1, 0), D(1, 0);

        int r, c;

        Dir(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int solution(String s) {
        StringBuilder sb = new StringBuilder();
        Set<String> routes = new HashSet<>();
        int r = 5;
        int c = 5;

        for (int i = 0; i < s.length(); i++) {
            Dir dir = Dir.valueOf(String.valueOf(s.charAt(i)));

            int nr = r + dir.r;
            int nc = c + dir.c;

            if (isCanNotMove(nr, nc)) {
                continue;
            }

            String start = sb.append(r).append(c).toString();
            sb.setLength(0);

            String end = sb.append(nr).append(nc).toString();
            sb.setLength(0);

            routes.add(start + end);
            routes.add(end + start);

            r = nr;
            c = nc;
        }

        return routes.size() / 2;
    }

    private static boolean isCanNotMove(int nr, int nc) {
        return !(nr >= 0 && nc >= 0 && nr <= 10 && nc <= 10);
    }

}
