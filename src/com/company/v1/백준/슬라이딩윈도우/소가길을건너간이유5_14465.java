package com.company.v1.백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소가길을건너간이유5_14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int trafficLightCount = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int breakTrafficLightCount = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[trafficLightCount+1];

        for (int i = 1; i <= trafficLightCount; i++) {
            arr[i] = true;
        }

        for (int i = 1; i <= breakTrafficLightCount; i++) {
            arr[Integer.parseInt(br.readLine())] = false;
        }

        int startIndex = 1;
        int endIndex = K;
        int minFixTrafficLightCount = Integer.MAX_VALUE;
        while (endIndex <= trafficLightCount) {
            int FixTrafficLightCount = 0;

            for (int i = startIndex; i <= endIndex; i++) {
                if (!arr[i]) FixTrafficLightCount++;
            }

            minFixTrafficLightCount = Math.min(minFixTrafficLightCount, FixTrafficLightCount);
            startIndex++;
            endIndex++;
        }

        System.out.println(minFixTrafficLightCount);

    }
}
