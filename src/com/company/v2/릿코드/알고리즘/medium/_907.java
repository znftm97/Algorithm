package com.company.v2.릿코드.알고리즘.medium;

import java.util.Stack;

public class _907 {

    private static final long MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i= 0; i < arr.length+1; i++){
            int nowVal = (i<=arr.length-1)? arr[i] : 0;

            while (stack.peek() != -1 && nowVal < arr[stack.peek()]) {
                int idx = stack.pop();
                int j = stack.peek();
                int left = idx - j;
                int right = i - idx;

                result += (left * right * (long) arr[idx]) % MOD;
                result %= MOD;
            }
            stack.push(i);
        }

        return result;
    }
}
