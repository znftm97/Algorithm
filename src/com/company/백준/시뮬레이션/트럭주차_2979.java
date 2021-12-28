package com.company.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트럭주차_2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] times = new int[101];

        int maxTime = 0;
        int minTime = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            for (int j = startTime; j < endTime; j++) {
                times[j]++;
            }

            minTime = Math.min(minTime, startTime);
            maxTime = Math.max(maxTime, endTime);
        }

        int parkingFee = 0;
        for (int i = minTime; i < maxTime; i++) {
            if (times[i] == 1) {
                parkingFee += A;
            } else if (times[i] == 2) {
                parkingFee += 2 * B;
            } else if (times[i] == 3) {
                parkingFee += 3 * C;
            }
        }

        System.out.println(parkingFee);
        br.close();
    }

}
