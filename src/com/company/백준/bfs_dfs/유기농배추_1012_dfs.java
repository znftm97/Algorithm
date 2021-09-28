package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012_dfs {
    static int[][] map; // 지도
    static int needBug; // 필요한 지렁이 수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy= {0, 0, -1, 1};
    static int mapSizeX; // 지도 가로 크기
    static int mapSizeY; // 지도 세로 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        /*테스트 케이스 수 만큼 반복*/
        for (int a = 0; a < testCase; a++) {
            needBug = 0; // 각 테스트케이스 마다 필요한 지렁이 수를 초기화
            st = new StringTokenizer(br.readLine(), " ");

            mapSizeX = Integer.parseInt(st.nextToken());
            mapSizeY = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            map = new int[mapSizeX][mapSizeY];

            /*지도에 자료 입력*/
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            /*한 좌표씩 조회하면서 1일경우 dfs 호출하고, 한 단지를 모두 조회 후(재귀호출을 탈출 후) 다시 한 좌표씩 조회*/
            for (int i = 0; i < mapSizeX; i++) {
                for (int j = 0; j < mapSizeY; j++) {
                    if (map[i][j] == 1) {
                        needBug++; // 조회하다가 좌표가 1일때 즉 첫 배추를 발견했을 경우이므로(배추가 뭉쳐있는 즉 단지와 같은개념), needBug 증감
                        dfs(i, j); // 한 좌표씩 조회해서 좌표가 1일때 dfs 호출
                    }
                }
            }

            System.out.println(needBug);
        }// 테스트케이스 반복문 종료
    }// 메인 메서드 종료

    static void dfs(int x, int y) {
        map[x][y] = 0; // 조회한 좌표를 지도에서 0으로 초기화, 그래야 해당 좌표를 다시 조회하지 않음

        /*상하좌우 값이 1인걸 찾기위해 4번 반복*/
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];// dx 배열의 -1, 1, 0, 0 값을 차례대로 넣고, 파라미터로 전달된 좌표의 x값과 더해 nx 생성
            int ny = y + dy[i]; // dy 배열의 0, 0, -1, 1 값을 차례대로 넣고, 파라미터로 전달된 좌표의 y값과 더해 ny 생성

            /*새로 구한 좌표값(상,하,좌,우)이 0보다 작거나, mapSize 보다 큰 경우는 맵에서 벗어나는 경우이므로 제외*/
            if (0 <= nx && nx < mapSizeX && 0 <= ny && ny < mapSizeY) {
                if (map[nx][ny] == 1) { // 새로 구한 좌표값(상,하,좌,우)이 1이면 조회를 안한 좌표이므로(조회한 좌표는 위에서 0으로 초기화했으므로) 다시 dfs 호출출
                    dfs(nx, ny);
                }
            }
        }
    }// dfs 종료

}
