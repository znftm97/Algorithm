package com.company.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2차원배열의합_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        /*배열에 값 입력*/
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*누적 합*/
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M - 1; j++) { // M에서 1을 빼줘야함, j가 다음 요소를 탐색하므로
                arr[i][j+1] = arr[i][j+1] + arr[i][j];
            }
            if(i!=N-1){ // i가 다음 행을 탐색하므로 마지막 행일때는 수행하면 안됨
                arr[i+1][0] = arr[i][M-1] + arr[i+1][0]; // 한 행 누적합이 끝나면 다음행의 첫번째 열 값과 더해줘야함
            }
        }

        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

        }


    }

}
