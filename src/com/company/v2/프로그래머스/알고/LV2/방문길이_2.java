package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 방문길이_2 {
    enum Dir {
        U(1,0), R(0,1), D(-1,0), L(0, -1);

        int r,c;
        Dir(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }

    public int solution(String dirs) {
        Set<String> routes = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int r = 0;
        int c = 0;

        for(int i = 0; i<dirs.length(); i++) {
            char ch = dirs.charAt(i);
            Dir dir = Dir.valueOf(String.valueOf(ch));
            int nr = r + dir.r;
            int nc = c + dir.c;

            if(isInArea(nr, nc)) {
                sb.append(r).append(c).append(nr).append(nc);
                routes.add(sb.toString());
                sb.setLength(0);

                sb.append(nr).append(nc).append(r).append(c);
                routes.add(sb.toString());
                sb.setLength(0);

                r = nr;
                c = nc;
            }
        }

        return routes.size() / 2;
    }

    static boolean isInArea(int r, int c) {
        return r>=-5 && c>=-5 && r<=5 && c<=5;
    }
}
