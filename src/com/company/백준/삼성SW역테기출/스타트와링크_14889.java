package com.company.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
    private static int N;
    private static int[][] map;
    private static boolean[] visit;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        System.out.println(result);
        br.close();
    }

    private static void dfs(int num, int depth){
        if (depth == N / 2) {
            result = Math.min(getDiff(), result);
            return;
        }

        for (int i = num; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int getDiff(){
        int aTeamSum = 0;
        int bTeamSum = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visit[i] && visit[j]) aTeamSum += map[i][j] + map[j][i];
                else if(!visit[i] && !visit[j]) bTeamSum += map[i][j] + map[j][i];
            }
        }

        int diff = Math.abs(aTeamSum - bTeamSum);
        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        return diff;
    }

}
