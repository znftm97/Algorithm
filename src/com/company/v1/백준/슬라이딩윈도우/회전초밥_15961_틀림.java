package com.company.v1.백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 회전초밥_15961_틀림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dishCount = Integer.parseInt(st.nextToken());
        int sushiKinds = Integer.parseInt(st.nextToken());
        int dishContinuous = Integer.parseInt(st.nextToken());
        int couponNum = Integer.parseInt(st.nextToken());
        int[] belt = new int[dishCount];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < dishCount; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < dishContinuous; i++) {
            map.put(belt[i], map.getOrDefault(belt[i], 0) + 1);
        }

        map.put(couponNum, map.getOrDefault(couponNum, 0) + 1); // 쿠폰값 삽입
        int nowKinds = map.size(); // map의 size는 곧 초밥 종류의 수
        int max = nowKinds;

        int startIndex = 0;
        int endIndex = dishContinuous - 1;
        while (endIndex < dishCount - 1) {
            if(map.get(belt[startIndex]) >= 2 && map.getOrDefault(belt[endIndex+1], 0) == 0){
                map.put(belt[startIndex], map.get(belt[startIndex]) - 1);
                map.put(belt[endIndex+1], 1);
                nowKinds++;
            } else if (map.get(belt[startIndex]) == 1 && map.getOrDefault(belt[endIndex + 1], 0) >= 1) {
                map.put(belt[endIndex + 1], map.get(belt[endIndex + 1]) + 1);
                map.put(belt[startIndex], 0);
                nowKinds--;
            } else {
                map.put(belt[startIndex], 0);
                map.put(belt[endIndex], 1);
            }

            max = Math.max(nowKinds, max);
            startIndex++;
            endIndex++;
        }

        System.out.println(max);
        br.close();
    }
}
