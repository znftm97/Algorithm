package com.company.v2.프로그래머스.알고.LV2;

public class 양궁대회 {
    static int[] rInfos;
    static int[] aInfos;
    static int maxGap = -1;
    static int[] result = new int[11];
    static boolean canWin = false;

    public int[] solution(int n, int[] info) {
        rInfos = new int[11];
        aInfos = info.clone();

        recursion(0, 0, n);

        return canWin ? result : new int[]{-1};
    }

    static void recursion(int depth, int start, int n) {
        if(depth == n) {
            int rScore = 0;
            int aScore = 0;

            for(int i = 0; i<11; i++) {
                if(rInfos[i] == 0 && aInfos[i] == 0) continue;

                if(rInfos[i] > aInfos[i]) rScore += 10 - i;
                else aScore += 10 - i;
            }

            if(rScore > aScore && rScore - aScore >= maxGap) {
                canWin = true;
                makeResult(rScore, aScore);
            }

            return;
        }

        for(int i = start; i<11; i++) {
            rInfos[i]++;
            recursion(depth + 1, i, n);
            rInfos[i]--;
        }
    }

    static void makeResult(int rScore, int aScore) {
        int gap = rScore - aScore;

        if(gap > maxGap) {
            maxGap = gap;
            result = rInfos.clone();
            return;
        }

        for(int i = 10; i>=0; i--) {
            if(result[i] > rInfos[i]) break;
            else if(result[i] < rInfos[i]) {
                result = rInfos.clone();
                break;
            }
        }
    }
}
