package com.company.v2.코드트리.프로그래밍연습.시뮬2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가운데에서_시작하여_빙빙_돌기 {
    private static int N;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dr = {0, -1, 0, 1}; // 동,북,서,남
        int[] dc = {1, 0, -1, 0};
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int nowNum = 1;
        int r = N / 2;
        int c = N / 2;
        int dir = 0;
        int move = 1;

        while (isAbleArea(r, c)) {
            for (int i = 0; i < move; i++) {
                map[r][c] = nowNum++;

                r += dr[dir];
                c += dc[dir];
            }

            dir = changeDir(dir);

            if (dir == 0 || dir == 2) {
                move++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isAbleArea(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static int changeDir(int dir) {
        dir += 1;
        return dir % 4;
    }

}
