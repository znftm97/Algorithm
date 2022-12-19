package com.company.v1.코드트리.시뮬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5 4 5 3 -> SUN
// 5월 4일이 월요일이라면 5월 3일은 무슨요일?
public class 요일맞추기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] daysOfTheWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int sourceDay = d1;
        int targetDay = d2;
        for (int i = 0; i < m1 - 1; i++) sourceDay += days[i];
        for (int i = 0; i < m2 - 1; i++) targetDay += days[i];

        int diffDay = targetDay - sourceDay;
        while (diffDay < 0) diffDay += 7;

        System.out.println(daysOfTheWeek[diffDay % 7]);
    }

}
