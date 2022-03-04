package com.company.프로그래머스.BfsDfs;

public class 피로도 {
    private static boolean[] visit;
    private static int result = 0;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        recursion(0, k, dungeons);

        return result;
    }

    private static void recursion(int depth, int nowTiredScore, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++) {
            if(visit[i] || dungeons[i][0] > nowTiredScore) continue;

            visit[i] = true;
            nowTiredScore -= dungeons[i][1];
            recursion(depth + 1, nowTiredScore, dungeons);
            visit[i] = false;
            nowTiredScore += dungeons[i][1];
        }

        result = Math.max(result, depth);
    }

}
