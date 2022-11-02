package com.company.v2.코드트리.프로그래밍연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잔해물을_덮기위한_사각형_최소넓이 {
    private static final int MAX = 1000;
    private static final int WHITE = 111; // 첫 번째 사각형을 흰색으로 표시
    private static final int BLACK = 222; // 두 번째 사각형을 검은색으로 표시
    private static int[][] arr = new int[MAX * 2 + 1][MAX * 2 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int firstLeftDownR = Integer.parseInt(st.nextToken()) + MAX;
        int firstLeftDownC = Integer.parseInt(st.nextToken()) + MAX;
        int firstRightUpR = Integer.parseInt(st.nextToken()) + MAX;
        int firstRightUpC = Integer.parseInt(st.nextToken()) + MAX;

        st = new StringTokenizer(br.readLine());
        int SecondLeftDownR = Integer.parseInt(st.nextToken()) + MAX;
        int SecondLeftDownC = Integer.parseInt(st.nextToken()) + MAX;
        int SecondRightUpR = Integer.parseInt(st.nextToken()) + MAX;
        int SecondRightUpC = Integer.parseInt(st.nextToken()) + MAX;

        draw(firstLeftDownR, firstLeftDownC, firstRightUpR, firstRightUpC, WHITE);
        draw(SecondLeftDownR, SecondLeftDownC, SecondRightUpR, SecondRightUpC, BLACK);

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = -1;
        int maxC = -1;
        boolean hasNotWhite = true;

        for (int i = firstLeftDownR; i <= firstRightUpR; i++) {
            for (int j = firstLeftDownC; j <= firstRightUpC; j++) {
                if (arr[i][j] == WHITE) {
                    hasNotWhite = false;
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (hasNotWhite) {
            System.out.println(0);
        } else {
            System.out.println((maxR - minR + 1) * (maxC - minC + 1));
        }
    }

    private static void draw(int leftDownR, int leftDownC, int rightUpR, int rightUpC, int color) {
        for (int r = leftDownR; r < rightUpR; r++) {
            for (int c = leftDownC; c < rightUpC; c++) {
                arr[r][c] = color;
            }
        }
    }

}
