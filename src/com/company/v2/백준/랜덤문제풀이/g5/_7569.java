package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 {
    private static final int RIPE = 1;
    private static final int NOT_RIPE = 0;
    private static int R,C,H,notRipeTomatoCnt;
    private static int[][][] map;
    private static int[] dh = {0, 0, 0, 0, -1, 1};
    private static int[] dr = {-1, 1, 0, 0, 0, 0};
    private static int[] dc = {0, 0, -1, 1, 0, 0};
    private static Queue<Tomato> nextDayQ = new LinkedList<>();

    private static class Tomato{
        int h,r,c;

        public Tomato(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][R][C];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                    if(map[h][r][c] == NOT_RIPE) notRipeTomatoCnt++;
                    if(map[h][r][c] == RIPE) nextDayQ.add(new Tomato(h, r, c));
                }
            }
        }

        if (notRipeTomatoCnt == 0) {
            System.out.println(0);
            return;
        }

        int cookTomatoCnt = 0;
        int day = 0;
        while (true) {
            bfs();

            if (nextDayQ.size() == 0) {
                System.out.println(-1);
                return;
            }

            day++;
            cookTomatoCnt += nextDayQ.size();

            if (cookTomatoCnt == notRipeTomatoCnt) {
                System.out.println(day);
                return;
            }
        }
    }

    private static void bfs() {
        Queue<Tomato> q = new LinkedList<>(nextDayQ);

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            nextDayQ.poll();

            for (int i = 0; i < 6; i++) {
                int nh = tomato.h + dh[i];
                int nr = tomato.r + dr[i];
                int nc = tomato.c + dc[i];

                if (isInArea(nh,nr,nc) && map[nh][nr][nc] == NOT_RIPE) {
                    map[nh][nr][nc] = RIPE;
                    nextDayQ.add(new Tomato(nh, nr, nc));
                }
            }
        }
    }

    public static boolean isInArea(int nh, int nr, int nc){
        return nh >= 0 && nr >= 0 && nc >= 0 && nh < H && nr < R && nc < C;
    }
}
