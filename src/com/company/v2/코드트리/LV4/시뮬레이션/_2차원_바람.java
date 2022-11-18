package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2차원_바람 {
    private static int[][] map;
    private static int N, M;
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            rotate(r1, c1, r2, c2);
            changeToAvg(r1, c1, r2, c2);
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 한바퀴 회전
    private static void rotate(int r1, int c1, int r2, int c2) {
        int before = map[r1][c1];
        int after;
        int dir = 0;
        int r = r1;
        int c = c1;

        while (true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 바람 범위 벗어나면 방향 전환
            if (!isInWindArea(nr, nc, r1, c1, r2, c2)) {
                dir += 1;
                dir %= 4;
                continue;
            }

            after = map[nr][nc];
            map[nr][nc] = before;
            before = after;

            // 첫 좌표로 돌아오면 끝
            if (nr == r1 && nc == c1) {
                break;
            }

            r = nr;
            c = nc;
        }
    }

    // 평균값으로 변경
    private static void changeToAvg(int r1, int c1, int r2, int c2) {
        int[][] tmp = new int[map.length][map[0].length]; // 조건이 동시에 변경이므로 변경된 값을 적용하면 안됨, 배열 복사

        for (int i = 0; i < map.length; i++) {
            tmp[i] = map[i].clone();
        }

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                int sum = tmp[r][c];
                int cnt = 1;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (isInMapArea(nr, nc)) {
                        sum += tmp[nr][nc];
                        cnt++;
                    }
                }

                map[r][c] = sum / cnt;
            }
        }
    }

    private static boolean isInWindArea(int nr, int nc, int r1, int c1, int r2, int c2) {
        return nr >= r1 && nc >= c1 && nr <= r2 && nc <= c2;
    }

    private static boolean isInMapArea(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= M;
    }

}
