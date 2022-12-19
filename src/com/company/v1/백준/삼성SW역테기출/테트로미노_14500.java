package com.company.v1.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
    private static int R, C;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dfs(i, j, 0, 0);
                restOfTheShape(i, j);
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void dfs(int r, int c, int depth, int sum){
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (isAbleArea(nr, nc) && isAbleVisit(nr, nc)) {
                visit[nr][nc] = true;
                dfs(nr, nc, depth + 1, sum + map[nr][nc]);
                visit[nr][nc] = false;
            }
        }
    }

    /*ㅗㅜㅓㅏ 도형 구하기*/
    private static void restOfTheShape(int r, int c){
        int wing = 4;
        int sum = map[r][c];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isAbleArea(nr, nc)) {
                wing--;
                continue;
            }

            min = Math.min(min, map[nr][nc]);
            sum += map[nr][nc];
        }

        if (wing == 4) { // wing 값이 안변했으면 + 모형이니까 최소값 하나 빼서 원하는 모형의 최대값 구하기
            sum -= min;
        }

        result = Math.max(result, sum); // wing이 4미만이면 원하는 모형이 아니지만 어차피 4개보다 최대값 높을 수 없으므로 그냥 비교해줌
    }

    private static boolean isAbleArea(int nr, int nc){
        if (nr >= 0 && nc >= 0 && nr < R && nc < C) return true;
        return false;
    }

    private static boolean isAbleVisit(int nr, int nc){
        if (!visit[nr][nc]) return true;
        return false;
    }

}
