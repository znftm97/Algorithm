package com.company.v2.프로그래머스.알고.LV3;

import java.util.*;

public class 표병합 {

    static List<String> results = new ArrayList<>();
    static int N = 50;
    static int totalMergeNum = 1;
    static int[][] merges = new int[N + 1][N + 1];
    static String[][] map = new String[N + 1][N + 1];
    static final String EMPTY = "EMPTY";

    public List<String> solution(String[] commands) {
        for (int r = 0; r < map.length; r++) {
            Arrays.fill(map[r], EMPTY);
        }

        for(String command : commands) {
            String[] splits = command.split(" ");

            switch (splits[0]) {
                case "UPDATE" -> {
                    if (splits.length >= 4) {
                        int r = stringToInt(splits[1]);
                        int c = stringToInt(splits[2]);
                        targetUpdate(r, c, splits[3]);
                    } else {
                        allUpdate(splits[1], splits[2]);
                    }
                }
                case "MERGE" -> {
                    int r1 = stringToInt(splits[1]);
                    int c1 = stringToInt(splits[2]);
                    int r2 = stringToInt(splits[3]);
                    int c2 = stringToInt(splits[4]);
                    merge(r1, c1, r2, c2);
                }
                case "UNMERGE" -> {
                    int r = stringToInt(splits[1]);
                    int c = stringToInt(splits[2]);
                    unMerge(r, c);
                }
                case "PRINT" -> {
                    int r = Integer.parseInt(splits[1]);
                    int c = Integer.parseInt(splits[2]);
                    results.add(map[r][c]);
                }
            }
        }

        return results;
    }

    static void targetUpdate(int targetR, int targetC, String s) {
        if(merges[targetR][targetC] == 0) {
            map[targetR][targetC] = s;
            return;
        }

        for(int r = 1; r<=N; r++) {
            for (int c = 1; c <= N; c++) {
                if (merges[r][c] == merges[targetR][targetC]) {
                    map[r][c] = s;
                }
            }
        }
    }

    static void allUpdate(String origin, String s) {
        for(int r = 1; r<=N; r++) {
            for(int c= 1; c<=N; c++) {
                if(map[r][c].equals(origin)) {
                    map[r][c] = s;
                }
            }
        }
    }

    static void merge(int r1, int c1, int r2, int c2) {
        if(r1 == r2 && c1 == c2) {
            return;
        }

        int mergeNum1 = merges[r1][c1];
        int mergeNum2 = merges[r2][c2];
        if(mergeNum1 == 0 && mergeNum2 == 0) {
            merges[r1][c1] = totalMergeNum;
            merges[r2][c2] = totalMergeNum;
            totalMergeNum++;
        } else if(mergeNum1 == 0 && mergeNum2 != 0) {
            merges[r1][c1] = mergeNum2;
        } else if(mergeNum1 != 0 && mergeNum2 == 0) {
            merges[r2][c2] = mergeNum1;
        } else {
            for(int r = 1; r<=N; r++) {
                for(int c = 1; c<=N; c++) {
                    if(merges[r][c] == mergeNum2) {
                        merges[r][c] = mergeNum1;
                    }
                }
            }
        }

        String s = "";
        if(map[r1][c1].equals(EMPTY)) {
            s = map[r2][c2];
        } else {
            s = map[r1][c1];
        }

        for(int r = 1; r<=N; r++) {
            for(int c = 1; c<=N; c++) {
                if(merges[r][c] == merges[r1][c1]) {
                    map[r][c] = s;
                }
            }
        }
    }

    static void unMerge(int targetR, int targetC) {
        if(merges[targetR][targetC] == 0) {
            return;
        }

        String s = map[targetR][targetC];
        int mergeNum = merges[targetR][targetC];
        for(int r = 1; r<=N; r++) {
            for(int c = 1; c<=N; c++) {
                if(merges[r][c] == mergeNum) {
                    merges[r][c] = 0;
                    map[r][c] = EMPTY;
                }
            }
        }

        map[targetR][targetC] = s;
    }

    static int stringToInt(String s) {
        return Integer.parseInt(s);
    }
}
