package com.company.프로그래머스.Etc;

import java.util.HashSet;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                hs.add(numbers[i] + numbers[j]);
            }
        }

        return hs.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
