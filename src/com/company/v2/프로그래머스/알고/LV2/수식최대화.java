package com.company.v2.프로그래머스.알고.LV2;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
    static List<Long> nums = new ArrayList<>();
    static List<Character> operators = new ArrayList<>();

    public long solution(String expression) {
        long result = 0;
        char[][] priorities = {
                {'*','+','-'},
                {'*','-','+'},
                {'+','*','-'},
                {'+','-','*'},
                {'-','+','*'},
                {'-','*','+'}
        };

        parsing(expression);

        for(int i = 0; i<priorities.length; i++) {
            long sum = calculate(priorities[i]);
            result = Math.max(result, sum);
        }

        return result;
    }

    static void parsing(String s) {
        for(int i = 0; i<s.length(); i++) {
            for(int j = i; j<s.length(); j++) {
                char c = s.charAt(j);
                if(!Character.isDigit(c)) {
                    nums.add(Long.parseLong(s.substring(i, j)));
                    operators.add(c);
                    i = j;
                    break;
                }
            }
        }

        for(int i = s.length() - 1; i>=0; i--) {
            if(!Character.isDigit(s.charAt(i))) {
                nums.add(Long.parseLong(s.substring(i + 1)));
                break;
            }
        }
    }

    static long calculate(char[] priority) {
        List<Long> cNums = new ArrayList<>(nums);
        List<Character> cOperators = new ArrayList<>(operators);

        for(int i = 0; i<priority.length; i++) {
            char oper = priority[i];

            while (true) {
                long calResult = 0;
                boolean flag = true;

                for(int j = 0; j<cOperators.size(); j++) {
                    if(cOperators.get(j) == oper) {
                        flag = false;
                        if(oper == '*') calResult += cNums.get(j) * cNums.get(j + 1);
                        else if(oper == '-') calResult += cNums.get(j) - cNums.get(j + 1);
                        else if(oper == '+') calResult += cNums.get(j) + cNums.get(j + 1);

                        cNums.remove(j);
                        cNums.remove(j);

                        if(j != 0) cNums.add(j, calResult);
                        else cNums.add(0, calResult);

                        cOperators.remove(cOperators.indexOf(oper));
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }
        }

        return Math.abs(cNums.get(0));
    }
}
