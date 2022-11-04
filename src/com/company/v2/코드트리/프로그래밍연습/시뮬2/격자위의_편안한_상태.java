package com.company.v2.코드트리.프로그래밍연습.시뮬2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자위의_편안한_상태 {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[][] arr;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r][c] = true;
            isComfortable(r, c);
        }

        System.out.println(sb);
    }

    private static void isComfortable(int r, int c) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && arr[nr][nc]) {
                cnt++;
            }
        }

        if (cnt == 3) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    private static boolean isAbleArea(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }

}
