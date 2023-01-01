package com.company.v2.프로그래머스.알고.LV2;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    public static int solution(int[] elements) {
        Set<Integer> results = new HashSet<>();

        for (int num : elements) {
            results.add(num);
        }

        for (int round = 0; round < elements.length; round++) {

            int endIdx = 1;
            for (int i = 0; i < elements.length - 1; i++) {
                results.add(getSum(elements, endIdx));
                endIdx++;
            }

            moveElement(elements);
        }

        return results.size();
    }

    private static int getSum(int[] elements, int endIdx) {
        int sum = 0;

        for (int i = 0; i <= endIdx; i++) {
            sum += elements[i];
        }

        return sum;
    }

    private static void moveElement(int[] elements) {
        int tmp = elements[0];

        for (int i = 1; i < elements.length; i++) {
            elements[i - 1] = elements[i];
        }

        elements[elements.length - 1] = tmp;
    }

}
