package com.company.v2.코드트리.LV2.완탐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스승의_은혜2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] prices = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices);

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int maxStudent = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    sum += prices[j] / 2;
                } else {
                    sum += prices[j];
                }

                if (sum > money) {
                    break;
                }

                maxStudent++;
            }

            result = Math.max(result, maxStudent);
        }

        System.out.println(result);
    }

}
