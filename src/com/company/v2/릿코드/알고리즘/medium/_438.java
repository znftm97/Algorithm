package com.company.v2.릿코드.알고리즘.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        Map<Character, Integer> alphabetToCntMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            alphabetToCntMap.put(p.charAt(i), alphabetToCntMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = p.length() - 1;

        while (end < s.length()) {
            int[] counts = new int[26];
            for (int i = start; i <= end; i++) {
                counts[s.charAt(i) - 'a']++;
            }

            boolean flag = true;
            for (char c = 'a'; c <= 'z'; c++) {
                if(counts[c - 'a'] == 0) continue;

                if (!alphabetToCntMap.containsKey(c) || counts[c - 'a'] != alphabetToCntMap.get(c)) {
                    flag = false;
                    break;
                }
            }

            if(flag) results.add(start);

            start++;
            end++;
        }

        return results;
    }
}
