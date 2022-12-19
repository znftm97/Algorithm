package com.company.v1.프로그래머스.백트래킹;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
    private static List<Long> originNums = new ArrayList<>();
    private static List<Character> originOperators = new ArrayList<>();
    private static boolean[] visit = new boolean[3];
    private static char[] operators = {'+', '-', '*'};
    private static char[] customOperators = new char[3];
    private static long result;

    public long solution(String expression) {

        split(expression);
        recursion(0);

        return result;
    }

    /*피연산자, 연산자 분리*/
    private static void split(String expression){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                originNums.add(Long.parseLong(sb.toString()));
                originOperators.add(c);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        originNums.add(Long.parseLong(sb.toString()));
    }

    /*연산자 우선순위 순열 만들기*/
    private static void recursion(int depth){
        if(depth == 3){
            solve();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            customOperators[depth] = operators[i];
            recursion(depth + 1);
            visit[i] = false;
        }
    }

    /*순열로 찾은 연산자 우선순위대로 계산*/
    private static void solve() {
        List<Character> copyOperators = new ArrayList<>(originOperators);
        List<Long> copyNums = new ArrayList<>(originNums);

        for (char operator : customOperators) { // +, -, *
            for (int i = 0; i < copyOperators.size(); i++) { // 문제에 주어진 연산자 개수만큼
                if(operator != copyOperators.get(i)) continue;

                long num1 = copyNums.get(i);
                long num2 = copyNums.get(i + 1);
                long result = calculate(num1, num2, operator);

                copyNums.remove(i + 1);
                copyNums.remove(i);
                copyOperators.remove(i);

                copyNums.add(i, result);
                i--;
            }
        }

        result = Math.max(result, Math.abs(copyNums.get(0)));
    }

    private static long calculate(long num1, long num2, char operator){
        long result = 0;

        switch(operator) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
        }

        return result;
    }

}
