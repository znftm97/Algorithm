package com.company.v2.릿코드.알고리즘.medium;

public class _5 {

    public String longestPalindrome(String s) {
        String result = "";

        if(s.length() == 1) return s;
        if (s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0, 1);
        }

        for (int len = s.length(); len >= 2; len--) {
            int start = 0;
            int end = len - 1;

            while (end < s.length()) {
                result = s.substring(start, end + 1);

                if(isPalindrome(result)) return result;

                start++;
                end++;
            }
        }

        if (!isPalindrome(result)) {
            return result.substring(0, 1);
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        return isPalindrome;
    }

}
