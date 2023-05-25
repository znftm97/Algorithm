package com.company.v2.릿코드.알고리즘.medium;

import java.util.Stack;

public class _1472 {
    private Stack<String> forward;
    private Stack<String> back;

    public _1472(String homepage) {
        forward = new Stack<>();
        back = new Stack<>();
        forward.add(homepage);
    }

    public void visit(String url) {
        back.clear();
        forward.add(url);
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (forward.size() <= 1) return forward.peek();
            back.add(forward.pop());
        }

        return forward.peek();
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (back.isEmpty()) return forward.peek();
            forward.add(back.pop());
        }

        return forward.peek();
    }
}
