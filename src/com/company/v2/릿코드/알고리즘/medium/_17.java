package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.List;

public class _17 {
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();

        String alphabets[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            combine(alphabets[digits.charAt(i) - '0']);
        }

        return result;
    }

    private void combine(String str) {
        List<String> tmp = new ArrayList<>(result);
        result.clear();

        for (int i = 0; i < str.length(); i++) {
            for (String beforeStr : tmp) {
                result.add(beforeStr + str.charAt(i));
            }
        }
    }
}
