package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {
    static int[][] map;
    static int[][] coordinate = new int[1][2];
    static int[] dice = new int[7];
    static int N, M;
    static int[] dr = {0,0,0,-1,1};
    static int[] dc = {0,1,-1,0,0};

    private static void gameStart(int command) {
        int r = coordinate[0][0];
        int c = coordinate[0][1];

        int nr = r + dr[command];
        int nc = c + dc[command];

        if (isMove(nr, nc)) {
            coordinate[0][0] = nr;
            coordinate[0][1] = nc;

            rollDice(command);
            copyAndPrint();
        }
    }

    private static boolean isMove(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
            return true;
        }

        return false;
    }

    private static void copyAndPrint() {
        int r = coordinate[0][0];
        int c = coordinate[0][1];

        if(map[r][c] == 0){
            map[r][c] = dice[6];
        } else{
            dice[6] = map[r][c];
            map[r][c] = 0;
        }

        System.out.println(dice[1]);
    }

    private static void rollDice(int command) {
        int[] tmp = dice.clone();

        if (command == 1) { // 동
            dice[1] = tmp[4];
            dice[3] = tmp[1];
            dice[4] = tmp[6];
            dice[6] = tmp[3];
        } else if (command == 2) { // 서
            dice[1] = tmp[3];
            dice[3] = tmp[6];
            dice[4] = tmp[1];
            dice[6] = tmp[4];
        } else if (command == 3) { // 남
            dice[1] = tmp[5];
            dice[2] = tmp[1];
            dice[5] = tmp[6];
            dice[6] = tmp[2];
        } else if (command == 4){ // 북
            dice[1] = tmp[2];
            dice[2] = tmp[6];
            dice[5] = tmp[1];
            dice[6] = tmp[5];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coordinate[0][0] = Integer.parseInt(st.nextToken());
        coordinate[0][1] = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            gameStart(Integer.parseInt(st.nextToken()));
        }
    }

}
