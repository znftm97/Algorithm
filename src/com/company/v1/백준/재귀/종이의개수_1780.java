package com.company.v1.백준.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수_1780 {
    private static int[][] map;
    private static int minusOne = 0;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        sb.append(minusOne).append("\n").append(zero).append("\n").append(one);
        System.out.println(sb);
    }

    private static void partition(int r, int c, int size) {
        if (isPassRule(r, c, size)) {
            if(map[r][c] == -1) minusOne++;
            else if(map[r][c] == 0) zero++;
            else if(map[r][c] == 1) one++;

            return;
        }

        int nSize = size / 3;

        partition(r, c, nSize);
        partition(r, c + nSize, nSize);
        partition(r, c + 2*nSize, nSize);

        partition(r + nSize, c, nSize);
        partition(r + nSize, c + nSize, nSize);
        partition(r + nSize, c + 2*nSize, nSize);

        partition(r + 2*nSize, c, nSize);
        partition(r + 2*nSize, c + nSize, nSize);
        partition(r + 2*nSize, c + 2*nSize, nSize);
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
