package com.company.백준.기타.실4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제처럼 안쪽에서 바깥쪽이 아니라, 바깥쪽에서 안쪽으로 돌아가는 달팽이로 구현
public class 달팽이_1913 {
    private static int[][] map;
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int targetNum = Integer.parseInt(br.readLine());
        int startNum = N * N;
        map = new int[N][N];

        int r = 0;
        int c = 0;
        int dir = 0;
        while (startNum > 0) {
            map[r][c] = startNum--;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isChangeDirection(nr, nc, N)) {
                dir++;
                if (dir == 4) dir = 0;

                r += dr[dir];
                c += dc[dir];
            } else {
                r = nr;
                c = nc;
            }
        }

        StringBuilder sb = new StringBuilder();
        int targetR = 0;
        int targetC = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == targetNum) {
                    targetR = i + 1;
                    targetC = j + 1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetR).append(" ").append(targetC);

        System.out.println(sb);
    }

    // 맵을 벗어나거나, 이미 달팽이가 지나간 자리면은 방향 전환
    private static boolean isChangeDirection(int r, int c, int N) {
        if (r >= 0 && c >= 0 && r < N && c < N) {
            if(map[r][c] == 0){
                return false;
            }
        }

        return true;
    }

}
