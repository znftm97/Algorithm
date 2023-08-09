package com.company.v2.릿코드.알고리즘.medium;

import java.util.Stack;

public class _1209 {
    private class Alphabet {
        char c;
        int cnt;

        public Alphabet(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Alphabet> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().c == c) stack.peek().cnt++;
            else stack.add(new Alphabet(c, 1));

            if (!stack.isEmpty() && stack.peek().cnt == k) stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Alphabet alphabet = stack.pop();
            for (int i = 0; i < alphabet.cnt; i++) {
                sb.append(alphabet.c);
            }
        }

        return sb.reverse().toString();
    }
}
