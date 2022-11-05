package com.company.v2.코드트리.프로그래밍연습.시뮬2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동경로상에_있는_모든_숫자더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dr = {0, -1, 0, 1}; // 동,북,서,남
        int[] dc = {1, 0, -1, 0};
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        char[] commands = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = N / 2;
        int c = N / 2;
        int dir = 1;
        int sum = map[r][c];

        for (int i = 0; i < commands.length; i++) {
            char command = commands[i];

            if (command == 'L') {
                dir++;
                dir %= 4;
            } else if (command == 'R') {
                dir--;
                if (dir == -1) {
                    dir = 3;
                }
            } else {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (isAbleArea(nr, nc, N)) {
                    sum += map[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean isAbleArea(int r, int c, int N) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
