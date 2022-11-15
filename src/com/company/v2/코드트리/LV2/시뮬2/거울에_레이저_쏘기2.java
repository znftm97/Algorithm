package com.company.v2.코드트리.LV2.시뮬2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 거울에_레이저_쏘기2 {
    private static char[][] arr;
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, -1, 0, 1};
    private static int r, c, N, dir; // 동 : 1 , 서  : 3, 남 : 0, 북 : 2

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int K = Integer.parseInt(br.readLine());
        init(K);

        while (isAbleArea(r,c)) {
            calDir();

            r += dr[dir];
            c += dc[dir];

            result++;
        }

        System.out.println(result);
    }

    public static void init(int K) {
        if(K <= N) {
            r = 0;
            c = K - 1;
            dir = 0;
        } else if (K <= 2 * N) {
            r = K - N - 1;
            c = N - 1;
            dir = 1;
        } else if (K <= 3 * N) {
            r = N - 1;
            c = N - (K - 2 * N);
            dir = 2;
        } else {
            r = N - (K - 3 * N);
            c = 0;
            dir = 3;
        }
    }

    private static void calDir() {
        if (arr[r][c] == '/') {
            if (dir == 0 || dir == 2) {
                dir += 1;
            } else if (dir == 1 || dir == 3) {
                dir -= 1;
            }
        } else {
            if (dir == 0) {
                dir = 3;
            } else if (dir == 1) {
                dir = 2;
            } else if (dir == 2) {
                dir = 1;
            } else if (dir == 3) {
                dir = 0;
            }
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
