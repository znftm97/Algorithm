package com.company.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*문제 설명이 친절하지 못하다. 아니 설명이없다 출력값을 보고 유추해야한다.
* 1,1 2,3 이 주어지면 1,1 1,2 ... 2,2 2,3 의 값을 모두 더하는건데
* 1,3 2,3 이 주어지면 1,3 2,1 2,2 2,3 의 값을 모두 더하는게 아니라 1,3 2,3의 값만 더하는것이다.
* 직관적으로 마우스 드래그를 생각하면 될듯하다.
* 이 클래스는 원래 내가 생각한 모두 더하는 방식을 기준으로 풀이한 방법이다.
* */
public class _2차원배열의합_2167_Custom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];

        /*배열에 값 입력받으면서 누적합 구하기*/
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                arr[i][j] = arr[i][j-1] + Integer.valueOf(st.nextToken()); // 현재요소의 값 = 이전요소 값 + 현재요소 값
            }
            if(i!=N){ // i가 다음 행을 탐색하므로 마지막 행일때는 수행하면 안됨
                arr[i+1][0] = arr[i][M] + arr[i+1][0]; // 한 행 누적합이 끝나면 다음행의 첫번째 열 값과 더해줘야함
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            sb.append(arr[c][d] - arr[a][b - 1]).append("\n"); // y - (x-1) 공식 적용, 행은 고정이므로 열에서 1만 빼주면됨
        }

        System.out.println(sb.toString());
    }

}
