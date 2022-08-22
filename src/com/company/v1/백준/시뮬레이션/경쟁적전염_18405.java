package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 경쟁적전염_18405 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static int[][] map;
    private static List<List<Virus>> viruses = new ArrayList<>();
    private static int N;

    private static class Virus implements Comparable<Virus>{
        int r;
        int c;
        int num;

        public Virus(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Virus v) {
            return this.num - v.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    viruses.add(new ArrayList<>());
                    viruses.get(0).add(new Virus(i, j, map[i][j])); // 0초대에 존재하는 바이러스들
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int destR = Integer.parseInt(st.nextToken());
        int destC = Integer.parseInt(st.nextToken());

        for (int time = 0; time < S; time++) { // 1초마다 바이러스 확산
            Collections.sort(viruses.get(time)); // 바이러스 번호 기준 오름차순 정렬
            spread(time);
        }

        System.out.println(map[destR][destC]);
        br.close();
    }

    private static void spread(int time) {
        List<Virus> vrius = viruses.get(time); // time초에 존재하는 바이러스들

        for (Virus v : vrius) {
            for (int i = 0; i < 4; i++) {
                int nr = v.r + dr[i];
                int nc = v.c + dc[i];

                if (isAbleArea(nr, nc) && isSpread(nr, nc)) {
                    map[nr][nc] = v.num;
                    viruses.add(new ArrayList<>());
                    viruses.get(time + 1).add(new Virus(nr, nc, v.num)); // 확산시킨 바이러스는 (time+1)초에 추가
                }
            }
        }
    }

    private static boolean isAbleArea(int nr, int nc) {
        if (nr > 0 && nc > 0 && nr <= N && nc <= N) {
            return true;
        }

        return false;
    }

    private static boolean isSpread(int nr, int nc) {
        if (map[nr][nc] == 0) {
            return true;
        }

        return false;
    }

}
