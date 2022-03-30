package com.company.프로그래머스.LV3;

import java.util.*;

public class 입국심사_이분탐색 {
    public long solution(int n, int[] times) {
        long result = 0;

        Arrays.sort(times);
        long left = 0; // 최소
        long right = (long) n * times[times.length - 1]; // 최대로 걸릴 수 있는 시간

        while (left <= right) {
            long mid = (left + right) / 2;
            long passedPeople = 0;

            for (int i = 0; i < times.length; i++) { // 심사 통과 인원 계산
                passedPeople += mid / times[i];
            }

            if (passedPeople >= n) { // 통과 인원이 n보다 크거나, 같아도 최소 시간을 구하기 위해 반복
                right = mid - 1;
                result = mid;
            } else if (passedPeople < n) { // 통과 인원이 n보다 작은경우
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] times = {7, 10};
        int n = 6;

        입국심사_이분탐색 tmp = new 입국심사_이분탐색();
        long solution = tmp.solution(n, times);
        System.out.println(solution); // 28
    }
}
