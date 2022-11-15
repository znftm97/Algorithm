package com.company.v2.코드트리.LV2.시뮬1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요일맞추기 {

    private static final int[] DAY_OF_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] DAY_OF_WEEK = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int day1 = calDay(m1, d1);
        int day2 = calDay(m2, d2);
        int diffDay = day2 - day1;

        if (diffDay < 0) {
            diffDay *= -1;
            System.out.println(DAY_OF_WEEK[7 - (diffDay % 7)]);
        } else {
            System.out.println(DAY_OF_WEEK[diffDay % 7]);
        }

    }

    private static int calDay(int month, int day) {
        int totalDay = 0;

        for (int i = 1; i < month; i++) {
            totalDay += DAY_OF_MONTH[i];
        }

        return totalDay + day;
    }

}
