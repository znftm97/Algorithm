package com.company.프로그래머스.LV2;

import java.util.*;

public class 방문길이 {
    private static List<String> roads = new ArrayList<>();

    private enum Move{
        U(-1, 0), D(1, 0), R(0,1), L(0, -1);
        int r, c;

        Move(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(String dirs) {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int r = 0, c = 0, nr = 0, nc = 0;

        for (int i = 0; i < dirs.length(); i++) {
            Move move = Move.valueOf(String.valueOf(dirs.charAt(i)));
            nr = r + move.r;
            nc = c + move.c;

            if (isNotAbleArea(nr, nc)) { // 맵 벗어나면 좌표 이동안함
                nr = r;
                nc = c;
                continue;
            }

            // 시작 좌표, 끝좌표를 문자열로 저장해서 왔던길인지 판단 (0,0 -> 1,0) = 0010
            // 이 때 시작, 끝 좌표가 바뀌는 반대길 경우도 생각해야함 (1,0 -> 0,0) = 1000
            String startLocation = sb.append(r).append(c).toString();
            sb.setLength(0);
            String endLocation = sb.append(nr).append(nc).toString();
            sb.setLength(0);

            String road = startLocation + endLocation;
            String reverseRoad = endLocation + startLocation;

            if(isNotVisitRoad(road, reverseRoad)) {
                roads.add(road);
                roads.add(reverseRoad);
                result++;
            }

            r = nr;
            c = nc;
        }


        return result;
    }

    private static boolean isNotAbleArea(int nr, int nc){
        return nr > 5 || nr < -5 || nc > 5 || nc < -5;
    }

    private static boolean isNotVisitRoad(String road, String reverseRoad) {
        return !(roads.contains(road) && roads.contains(reverseRoad));
    }

}
