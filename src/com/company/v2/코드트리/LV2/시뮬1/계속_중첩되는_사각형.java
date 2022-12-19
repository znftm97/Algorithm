package com.company.v2.코드트리.LV2.시뮬1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계속_중첩되는_사각형 {

    private static final int MAX = 100;
    private static final int RED = 111;
    private static final int BLUE = 222;
    private static int[][] arr = new int[MAX * 2 + 1][MAX * 2 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int leftDownR = Integer.parseInt(st.nextToken()) + MAX;
            int leftDownC = Integer.parseInt(st.nextToken()) + MAX;
            int rightUpR = Integer.parseInt(st.nextToken()) + MAX;
            int rightUpC = Integer.parseInt(st.nextToken()) + MAX;

            if (i % 2 == 1) {
                draw(leftDownR, leftDownC, rightUpR, rightUpC, RED);
            } else {
                draw(leftDownR, leftDownC, rightUpR, rightUpC, BLUE);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == BLUE) result++;
            }
        }

        System.out.println(result);
    }

    private static void draw(int leftDownR, int leftDownC, int rightUpR, int rightUpC, int color) {
        for (int r = leftDownR; r < rightUpR; r++) {
            for (int c = leftDownC; c < rightUpC; c++) {
                arr[r][c] = color;
            }
        }
    }

}
