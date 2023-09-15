package com.company.v2.프로그래머스.알고.LV2;

public class 피로도 {
    static int[][] copyDungeons;
    static int max = 0;
    static boolean[] visited;
    static int N, K;

    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        K = k;
        copyDungeons = new int[N][2];
        visited = new boolean[N];

        recursion(0, dungeons);

        return max;
    }

    static void recursion(int depth, int[][] dungeons) {
        if(depth == N) {
            calculate();
            return;
        }

        for(int i = 0; i<N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            copyDungeons[depth] = dungeons[i];
            recursion(depth + 1, dungeons);
            visited[i] = false;
        }
    }

    static void calculate() {
        int k = K;
        int cnt = 0;
        for(int i = 0; i<copyDungeons.length; i++) {
            if(k >= copyDungeons[i][0]) {
                k-=copyDungeons[i][1];
                cnt++;
            }
        }

        max = Math.max(max, cnt);
    }
}
