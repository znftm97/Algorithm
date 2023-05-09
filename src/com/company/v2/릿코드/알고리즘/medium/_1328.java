package com.company.v2.릿코드.알고리즘.medium;

public class _1328 {

    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";

        char[] chars = palindrome.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c != 'a') {
                chars[i] = 'a';
                if (isNotPalindrome(chars)) break; // aba -> aaa
                else chars[i] = c;
            } else if (i == chars.length - 1) {
                chars[i] = 'b';
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static boolean isNotPalindrome(char[] chars) {
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return true;
            }
        }

        return false;
    }

}
