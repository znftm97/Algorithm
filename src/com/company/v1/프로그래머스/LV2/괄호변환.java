package com.company.v1.프로그래머스.LV2;

import java.util.Stack;

public class 괄호변환 {
    private static String[] uAndV = new String[2];

    public String solution(String p) {
        if(p.equals("")) return p; // 1

        boolean isCorrect = separation(p); // 2
        String u = uAndV[0];
        String v = uAndV[1];

        if(isCorrect) return u + solution(v); // 3, 3-1

        // 4
        StringBuilder sb = new StringBuilder();
        sb.append("("); // 4-1
        sb.append(solution(v)); // 4-2
        sb.append(")"); // 4-3

        // 4-4
        for (int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString(); // 4-5
    }

    private static boolean separation(String s){
        Stack<Character> stack = new Stack<>();
        boolean isCorrect = true;
        int index = 0, left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            index = i;

            if (s.charAt(i) == '(') {
                stack.add('(');
                left++;
            } else if (s.charAt(i) == ')') {
                right++;

                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                } else {
                    stack.add(')');
                    isCorrect = false;
                }
            }

            if (left == right) break;
        }

        uAndV[0] = s.substring(0, index + 1);
        uAndV[1] = s.substring(index + 1);

        return isCorrect;
    }

}
