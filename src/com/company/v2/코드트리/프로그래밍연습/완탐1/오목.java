package com.company.v2.코드트리.프로그래밍연습.완탐1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목 {
    private static final int MAP_SIZE = 19;
    private static int[][] map = new int[MAP_SIZE][MAP_SIZE];
    public static int[] dr = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dc = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {

                if (map[i][j] == 0) {
                    continue;
                }

                for (int dir = 0; dir < 8; dir++) {
                    int cnt = 1;
                    int r = i;
                    int c = j;

                    while (true) {
                        if (cnt == 5) {
                            System.out.println(map[i][j]);
                            System.out.print((i + 2 * dr[dir] + 1) + " " + (j + 2 * dc[dir] + 1));
                            return;
                        }

                        int nr = r + dr[dir];
                        int nc = c + dc[dir];

                        if (isAbleArea(nr, nc) && isEqualsColor(r, c, nr, nc)) {
                            r = nr;
                            c = nc;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                }

            }
        }

        System.out.println(0);
    }

    private static boolean isAbleArea(int r, int c){
        return r >= 0 && c >= 0 && r < MAP_SIZE && c < MAP_SIZE;
    }

    private static boolean isEqualsColor(int r, int c, int nr, int nc){
        return map[r][c] == map[nr][nc];
    }

}
