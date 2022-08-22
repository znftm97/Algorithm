package com.company.v1.프로그래머스.BfsDfs;

public class 네트워크 {
    static boolean visit[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for(int i = 0; i<n; i++){
            if(!visit[i]){
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int[][] computers, int x){
        if(visit[x]){
            return;
        }

        visit[x] = true;
        for(int i = 0; i<computers.length; i++){
            if(x != i && computers[x][i] == 1 && visit[i] == false){
                dfs(computers, i);
            }
        }
    }
}
