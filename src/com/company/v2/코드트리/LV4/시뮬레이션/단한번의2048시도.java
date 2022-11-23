package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단한번의2048시도 {
    private static final int N = 4;
    private static int[][] arr, copy;

    enum Dir{
        D(0), R(1), U(2), L(3);

        public int dir;

        Dir(int dir) {
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new int[N][N];
        copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String s = br.readLine();
        Dir D = Dir.valueOf(s);

        // 아래로 떨어지도록 회전
        for (int i = 0; i < D.dir; i++) {
            rotateToClockWise();
        }

        drop();
        sum();
        drop(); // 더한후 빈공간 생기므로 다시 떨구기

        // 처음 상태로 되돌리기 위해 회전
        for (int i = 0; i < N - D.dir; i++) {
            rotateToClockWise();
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 시계방향 회전
    private static void rotateToClockWise() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(copy[i], 0);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                copy[r][c] = arr[N - c - 1][r];
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] = copy[i].clone();
        }
    }

    private static void drop() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(copy[i], 0);
        }

        for (int c = 0; c < N; c++) {
            int nr = N - 1;
            for (int r = N - 1; r >= 0; r--) {
                if (arr[r][c] != 0) {
                    copy[nr--][c] = arr[r][c];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] = copy[i].clone();
        }
    }

    private static void sum() {
        for (int c = 0; c < N; c++) {
            for (int r = N - 1; r >= 1; r--) {
                if (arr[r][c] == arr[r - 1][c]) {
                    arr[r][c] = arr[r][c] * 2;
                    arr[r - 1][c] = 0;
                    r--;
                }
            }
        }
    }

}
