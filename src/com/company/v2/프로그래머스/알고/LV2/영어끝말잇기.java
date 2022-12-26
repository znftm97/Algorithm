package com.company.v2.프로그래머스.알고.LV2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] results = new int[2];
        Set<String> checkWords = new HashSet<>();

        checkWords.add(words[0]);
        char lastChar = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (lastChar != word.charAt(0) || checkWords.contains(word)) {
                results[0] = i % n + 1;
                results[1] = i / n + 1;
                break;
            }

            checkWords.add(word);
            lastChar = word.charAt(word.length() - 1);
        }

        return results;
    }

}
