package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세탁소사장동혁_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] moneys = {25, 10, 5, 1};
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int restMoney = Integer.parseInt(br.readLine());

            for (int i = 0; i < 4; i++) {
                int cnt = restMoney / moneys[i];
                restMoney %= moneys[i];

                sb.append(cnt).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
