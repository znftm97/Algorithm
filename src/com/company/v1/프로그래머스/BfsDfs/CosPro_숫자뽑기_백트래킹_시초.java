package com.company.v1.프로그래머스.BfsDfs;

public class CosPro_숫자뽑기_백트래킹_시초 {
    private static int[] customArr;
    private static int[] originArr;
    private static boolean[] visit;
    private static int count;
    private static int result = Integer.MAX_VALUE;

    public int solution(int[] arr, int K) {

        customArr = new int[arr.length];
        originArr = arr;
        visit = new boolean[arr.length];
        count = K;
        dfs(0);

        return result;
    }

    private static void dfs(int depth){
        if(depth == count){
            result = Math.min(result, calGap());
        }

        for(int i = 0; i<originArr.length; i++){
            if(visit[i]) continue;

            visit[i] = true;
            customArr[depth] = originArr[i];
            dfs(depth + 1);
            visit[i] = false;
        }

    }

    private static int calGap(){
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int num : customArr){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max - min;
    }

}
