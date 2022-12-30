package com.company.v2.프로그래머스.알고.LV2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (chars.isEmpty()) {
                chars.add(c);
                continue;
            }

            if (chars.peek() == c) {
                chars.pop();
            } else {
                chars.add(c);
            }
        }

        if (chars.isEmpty()) {
            return 1;
        }

        return 0;
    }


}
