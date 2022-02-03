package com.company.프로그래머스.LV2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int maxIndex = people.length - 1;
        int minIndex = 0;
        int result = 0;

        // 인덱스가 같아서 같은 사람의 몸무게를 2번 가져와도 상관없음. 같다는건 마지막남은 한명이기때문에
        while (maxIndex >= minIndex) {
            if (people[maxIndex] + people[minIndex] > limit) { // 한명만 탈출(몸무게 많은 사람이 탈출)
                maxIndex--;
                result++;
            } else { // 둘다 탈출
                result++;
                maxIndex--;
                minIndex++;
            }
        }

        return result;
    }

}
