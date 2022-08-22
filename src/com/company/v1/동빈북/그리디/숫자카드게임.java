package com.company.v1.동빈북.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < c; j++) {
                min = Math.min(min, Integer.parseInt(st.nextToken()));
            }
            result = Math.max(result, min);
        }

        System.out.println(result);
    }
}
