package com.company.v2.프로그래머스.알고.LV2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length - 1;
        int result = 0;

        Arrays.sort(people);

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
                result++;
            } else {
                end--;
                result++;
            }
        }

        return result;
    }

}
