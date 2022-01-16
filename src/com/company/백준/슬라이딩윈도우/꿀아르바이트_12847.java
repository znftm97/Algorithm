package com.company.백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀아르바이트_12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalDay = Integer.parseInt(st.nextToken());
        int workingDay = Integer.parseInt(st.nextToken());
        long[] pays = new long[totalDay];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalDay; i++) {
            pays[i] = Long.parseLong(st.nextToken());
        }

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < totalDay - workingDay + 1; i++) {
            long sum = 0;
            for (int j = i; j < i + workingDay; j++) {
                sum += pays[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }

}
