package com.company.v1.프로그래머스.BfsDfs;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static boolean[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int SizeOfOneArea; // 영역에 있는 그림 개수

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int numberOfArea = 0; // 영역 개수
        int maxSizeOfOneArea = 0; // 영역에 있는 그림 최대 개수
        visit = new boolean[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] > 0 && visit[i][j] == false){ // 여기서도 방문했는지 검사
                    SizeOfOneArea = 0;

                    numberOfArea++; // 영역 개수 카운팅
                    bfs(i, j, picture, m, n);

                    if(SizeOfOneArea > maxSizeOfOneArea){
                        maxSizeOfOneArea = SizeOfOneArea;
                    }
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static void bfs(int x, int y, int[][] map, int m, int n){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        visit[x][y] = true; // 방문처리
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty()){ // 큐가 빌때까지
            int curX = qx.poll();
            int curY = qy.poll();
            SizeOfOneArea++; // 영역에 있는 그림 개수 카운팅

            for(int i = 0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < m && ny < n && nx>= 0 && ny >=0){
                    if(map[nx][ny] == map[x][y] && visit[nx][ny] == false){ // 숫자로 영역을 구분하므로 이전 숫자와 같을때만 큐에 추가해야함(1==1)
                        visit[nx][ny] = true;
                        qx.add(nx);
                        qy.add(ny);
                    }
                }
            }
        }

    }
}
