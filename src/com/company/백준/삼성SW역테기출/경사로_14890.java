package com.company.백준.삼성SW역테기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {
    private static int N, bridgeLen;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        bridgeLen = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roadCnt = 0;
        for (int i = 0; i < N; i++) {
            if(findRoad(i, 0, true)) roadCnt++;
            if(findRoad(0, i, false)) roadCnt++;
        }

        System.out.println(roadCnt);
        br.close();
    }

    private static boolean findRoad(int r, int c, boolean isRow) {
        int[] heights = new int[N];
        boolean[] existBridge = new boolean[N];

        for (int i = 0; i < N; i++) {
            if(isRow) heights[i] = map[r][i];
            else heights[i] = map[i][c];
        }

        for (int i = 0; i < N - 1; i++) {
            int gap = heights[i] - heights[i + 1];

            if(gap == 0) continue;
            if (Math.abs(gap) >= 2) return false;

            if (gap == 1) { // 내림차순인 경우
                for (int j = i + 1; j <= i + bridgeLen; j++) {
                    if (j >= N || heights[i + 1] != heights[j] || existBridge[j]) return false;
                    existBridge[j] = true;
                }
            } else { // 오름차순인 경우
                for (int j = i; j > i - bridgeLen; j--) {
                    if (j < 0 || heights[i] != heights[j] || existBridge[j]) return false;
                    existBridge[j] = true;
                }
            }
        }

        return true;
    }

}
