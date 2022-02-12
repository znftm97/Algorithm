package com.company.백준.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {
    private static int[][] map;
    private static final int WHITE = 0;
    private static final int BLUE = 1;
    private static int whiteCnt = 0;
    private static int blueCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        sb.append(whiteCnt).append("\n").append(blueCnt);
        System.out.println(sb);
    }

    private static void partition(int r, int c, int size){
        if (isPassRule(r, c, size)) {
            if(map[r][c] == WHITE) whiteCnt++;
            else if(map[r][c] == BLUE) blueCnt++;

            return;
        }

        int nSize = size / 2;
        partition(r, c, nSize);
        partition(r, c + nSize, nSize);

        partition(r + nSize, c, nSize);
        partition(r + nSize, c + nSize, nSize);
    }

    private static boolean isPassRule(int r, int c, int size){
        int num = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(map[i][j] != num) return false;
            }
        }

        return true;
    }

}
