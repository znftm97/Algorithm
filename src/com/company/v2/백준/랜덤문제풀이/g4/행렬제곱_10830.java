package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬제곱_10830 {
    private static int[][] procession;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        long exponent = Long.parseLong(st.nextToken());
        procession = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                procession[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(procession, exponent);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int[][] pow(int[][] copyProcession, long exponent){

        if (exponent == 1L) {
            return copyProcession;
        }

        int[][] afterProcession = pow(copyProcession, exponent / 2);

        afterProcession = powProcession(afterProcession, afterProcession);

        if (exponent % 2 == 1L) {
            afterProcession = powProcession(afterProcession, procession);
        }

        return afterProcession;
    };

    private static int[][] powProcession(int[][] arr1, int[][] arr2) {
        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {

                    ret[i][j] += arr1[i][k] * arr2[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }

        return ret;
    }

}
