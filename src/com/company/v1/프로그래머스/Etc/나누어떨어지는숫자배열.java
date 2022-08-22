package com.company.v1.프로그래머스.Etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(arr);

        for (int i : arr) {
            if (i % divisor == 0) {
                answer.add(i);
            }
        }
        if (answer.size() == 0) {
            answer.add(-1);
        }

        return answer;
    }
}
