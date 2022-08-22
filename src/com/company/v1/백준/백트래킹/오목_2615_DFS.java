package com.company.v1.백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_2615_DFS {
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
    private static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*r, c 를 바꾼이유는 가장 왼쪽에 있는 바둑알의 번호를 출력해야 하기 때문이다.
         * 맨위왼쪽부터 오른쪽으로 탐색하는게 아니라, 맨위왼쪽부터 아래로 탐색하기 위해서 r과 c를 바꾼것
         * */
        for (int c = 0; c < 19; c++) {
            for (int r = 0; r < 19; r++) {
                if(map[r][c] == 1 || map[r][c] == 2) {
                    for (int dir = 0; dir < 8; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        int nr2 = r + dr[dir] * -1;
                        int nc2 = c + dc[dir] * -1;

                        if (isAbleArea(nr, nc) && isAbleArea(nr2, nc2) && isEqualsColor(nr, nc, nr2, nc2)) {
                            continue;
                        }

                        dfs(r, c, dir, 1);

                        if(result){
                            sb.append(map[r][c]).append("\n").append(r + 1).append(" ").append(c + 1);
                            System.out.println(sb);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static void dfs(int r, int c, int dir, int depth){
        if(depth == 5){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(isAbleArea(nr, nc) && isEqualsColor(r, c, nr, nc)) return;

            result = true;
            return;
        }

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if(isAbleArea(nr, nc) && isEqualsColor(r, c, nr, nc)){
            dfs(nr, nc, dir, depth + 1);
        }
    }

    private static boolean isAbleArea(int r, int c){
        return r >= 0 && c >= 0 && r < 19 && c < 19;
    }

    private static boolean isEqualsColor(int r, int c, int nr, int nc){
        return map[r][c] == map[nr][nc];
    }

}
