package com.company.v2.코드트리.프로그래밍연습.완탐1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨은단어찾기2 {
    private static int N, M;
    private static boolean isLEE;
    private static char[][] map;
    public static int[] dr = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dc = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 'L') {
                    continue;
                }

                for (int dir = 0; dir < 8; dir++) {
                    isLEE(r, c, dir, 0);

                    if (isLEE) {
                        result++;
                        isLEE = false;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void isLEE(int r, int c, int dir, int eCnt) {
        if (eCnt == 2) {
            isLEE = true;
            return;
        }

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (isAbleArea(nr, nc) && isE(nr, nc)) {
            isLEE(nr, nc, dir, eCnt + 1);
        }
    }

    private static boolean isAbleArea(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static boolean isE(int r, int c){
        return map[r][c] == 'E';
    }

}
