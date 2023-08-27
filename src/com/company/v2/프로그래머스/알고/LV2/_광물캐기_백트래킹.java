package com.company.v2.프로그래머스.알고.LV2;

import java.util.HashMap;
import java.util.Map;

public class _광물캐기_백트래킹 {
    static Map<String, Integer> pickToNumMap = new HashMap<>();
    static int result = Integer.MAX_VALUE;
    static int[] copyPicks;
    static int[][] cost = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    public int solution(int[] picks, String[] minerals) {
        pickToNumMap.put("diamond", 0);
        pickToNumMap.put("iron", 1);
        pickToNumMap.put("stone", 2);

        int pickLen = 0;
        for (int pick : picks) pickLen += pick;
        copyPicks = new int[pickLen];

        recursion(0, picks, minerals);

        return result;
    }

    static void recursion(int depth, int[] picks, String[] minerals) {
        if (depth == copyPicks.length) {
            result = Math.min(result, calculate(minerals));
        }

        for (int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            copyPicks[depth] = i;
            picks[i]--;
            recursion(depth + 1, picks, minerals);
            picks[i]++;
        }
    }

    static int calculate(String[] minerals) {
        int sum = 0;
        int mineralIdx = 0;

        for (int pick : copyPicks) {
            int cnt = 5;
            while (cnt-- > 0) {
                if(mineralIdx == minerals.length) return sum;

                sum += cost[pick][pickToNumMap.get(minerals[mineralIdx])];
                mineralIdx++;
            }
        }

        return sum;
    }
}
