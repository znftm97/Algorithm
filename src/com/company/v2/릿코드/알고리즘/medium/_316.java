package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _316 {
    public String removeDuplicateLetters(String s) {
        boolean[] alphabets = new boolean[26];
        Map<Character, Integer> charToLastIdxMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            charToLastIdxMap.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(alphabets[now - 'a']) continue;

            while (!stack.isEmpty() && now < stack.peek() && i < charToLastIdxMap.get(stack.peek())) {
                alphabets[stack.pop() - 'a'] = false;
            }

            stack.push(now);
            alphabets[now - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
