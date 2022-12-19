package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무조각_2947 {
    private static StringBuilder sb = new StringBuilder();

    private static void print(int[] pieces){
        for (int i = 0; i < 5; i++) {
            sb.append(pieces[i]).append(" ");
        }
        sb.append("\n");
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pieces = new int[5];
        for (int i = 0; i < 5; i++) {
            pieces[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pieces[j] > pieces[j + 1]) {
                    int tmp = pieces[j];
                    pieces[j] = pieces[j + 1];
                    pieces[j + 1] = tmp;

                    print(pieces);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
