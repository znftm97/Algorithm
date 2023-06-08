package com.company.v2.릿코드.알고리즘.medium;

import java.util.Arrays;

public class _567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Alphabets = new int[26];
        int[] s2Alphabets = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Alphabets[s1.charAt(i) - 'a']++;
            s2Alphabets[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Alphabets, s2Alphabets)) return true;

        int start = 0;
        int end = s1.length();
        while (end < s2.length()) {
            s2Alphabets[s2.charAt(start) - 'a']--;
            s2Alphabets[s2.charAt(end) - 'a']++;

            if(Arrays.equals(s1Alphabets, s2Alphabets)) return true;
            start++;
            end++;
        }

        return false;
    }
}
