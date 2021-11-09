package com.company.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503_dfs {
    static int[][] map;
    static int cleanCount = 1;
    static int mapSizeR, mapSizeC;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapSizeR = Integer.parseInt(st.nextToken());
        mapSizeC = Integer.parseInt(st.nextToken());
        map = new int[mapSizeR][mapSizeC];

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int startDirection = Integer.parseInt(st.nextToken());

        for (int i = 0; i < mapSizeR; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSizeC; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(startRow, startCol, startDirection);
        br.close();
        System.out.println(cleanCount);
    }

    private static void clean(int r, int c, int dir) {
        map[r][c] = -1; // 청소

        for (int i = 0; i < 4; i++) {
            dir -= 1; // 왼쪽으로 회전
            if(dir == -1) dir = 3; // 북에서 서로 방향바꿀때

            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr >= 0 && nc>=0 && nr<mapSizeR && nc<mapSizeC){
                if(map[nr][nc] == 0){
                    cleanCount++;
                    clean(nr, nc, dir);
                    return;
                }
            }
        }

        // 주변에 청소할 곳이 없을때
        int nd = (dir + 2) % 4; // 후진 방향
        int nr = r + dr[nd];
        int nc = c + dc[nd];
        if(nr >= 0 && nc>=0 && nr<mapSizeR && nc<mapSizeC){
            if(map[nr][nc] != 1){ // 벽만 아니면됨 (이미 청소한 곳으로 후진해도 됨)
                clean(nr, nc, dir);
            }
        }
    }
}
