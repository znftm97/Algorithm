package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursion(result, "", 0, 0, n);
        return result;
    }

    private static void recursion(List<String> result, String str, int open, int close, int n) {
        if (str.length() == n*2) {
            result.add(str);
            return;
        }

        if(open < n) recursion(result, str + "(", open + 1, close, n);
        if(close < open) recursion(result, str + ")", open, close + 1, n);
    }
}
