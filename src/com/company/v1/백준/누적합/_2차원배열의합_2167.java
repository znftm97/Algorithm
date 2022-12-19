package com.company.v1.백준.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*이 방법은 못쓰는 방법, 효율성 있는 문제는 통과 못함
* 따라서 11660 문제처럼 dp로 푸는방법 통일하자
* */
public class _2차원배열의합_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            for(int a = x1; a <= x2; a++) {
                for(int b = y1; b <= y2; b++) {
                    sum += arr[a][b];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
