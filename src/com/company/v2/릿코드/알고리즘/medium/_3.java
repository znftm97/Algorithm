package com.company.v2.릿코드.알고리즘.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _3 {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1) return 1;

        List<Character> strs = new ArrayList<>();
        int result = 0;
        int len = 0;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            flag = true;
            len++;

            char c = s.charAt(i);

            if (strs.contains(c)) {
                result = Math.max(result, --len);
                len = 0;
                strs.clear();
                i -= 1;
                flag = false;
                continue;
            }

            strs.add(c);
        }

        if(flag) return strs.size();

        return result;
    }

    public static void main(String[] args) {
        _3 asd = new _3();
        int pwwkew = asd.lengthOfLongestSubstring("a");
        System.out.println(pwwkew);
    }

}

