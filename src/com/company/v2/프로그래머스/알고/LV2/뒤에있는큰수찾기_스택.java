package com.company.v2.프로그래머스.알고.LV2;

import java.util.Stack;

public class 뒤에있는큰수찾기_스택 {
    static class Number {
        int num, idx;
        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] solution(int[] numbers) {
        int[] results = new int[numbers.length];
        Stack<Number> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            int now = numbers[i];

            while (!stack.isEmpty() && stack.peek().num < now) {
                Number pop = stack.pop();
                results[pop.idx] = now;
            }

            stack.push(new Number(now, i));
        }

        while (!stack.isEmpty()) {
            Number pop = stack.pop();
            results[pop.idx] = -1;
        }

        return results;
    }
}
