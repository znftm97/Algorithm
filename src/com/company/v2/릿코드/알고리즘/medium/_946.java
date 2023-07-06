package com.company.v2.릿코드.알고리즘.medium;

import java.util.Stack;

public class _946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);

        int pushIdx = 1;
        int popIdx = 0;

        while (pushIdx < pushed.length && popIdx < popped.length) {
            if (stack.isEmpty()) {
                stack.push(pushed[pushIdx++]);
            }

            int target = popped[popIdx];

            if (stack.peek() == target) {
                stack.pop();
                popIdx++;
                continue;
            }

            stack.push(pushed[pushIdx++]);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            } else {
                return false;
            }

            if (popIdx >= popped.length) {
                break;
            }
        }

        return stack.isEmpty();
    }
}
