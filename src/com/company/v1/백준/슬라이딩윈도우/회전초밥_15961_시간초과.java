package com.company.v1.백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 회전초밥_15961_시간초과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dishCount = Integer.parseInt(st.nextToken());
        int sushiKinds = Integer.parseInt(st.nextToken());
        int dishContinuous = Integer.parseInt(st.nextToken());
        int couponNum = Integer.parseInt(st.nextToken());
        int[] belt = new int[dishCount];

        for (int i = 0; i < dishCount; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int startIndex = 0;
        int endIndex = dishContinuous - 1;
        int max = Integer.MIN_VALUE;
        while (endIndex < dishCount) {
            Map<Integer, Integer> check = new HashMap<>();
            check.put(couponNum, 1);

            for (int i = startIndex; i <= endIndex; i++) {
                check.put(belt[i], check.getOrDefault(belt[i], 0) + 1);
            }

            max = Math.max(check.size(), max);
            startIndex++;
            endIndex++;
        }

        System.out.println(max);
        br.close();
    }
}
