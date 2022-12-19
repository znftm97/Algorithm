package com.company.v1.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        /*e1과 e2는 x축 배열*/
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1] == e2[1]) { // y좌표값이 같으면 x좌표값을 비교
                return e1[0] - e2[0]; // 앞에 x좌표값이 더 크면 양수값 리턴 --> 자리 교체
            }else { // y좌표값이 다르면 y좌표값끼리 비교
                return e1[1] - e2[1]; // 앞에 y좌표값이 더 크면 양수값 리턴 --> 자리교체
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}
