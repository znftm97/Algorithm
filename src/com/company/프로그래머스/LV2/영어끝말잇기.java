package com.company.프로그래머스.LV2;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {
    private static List<String> stackinWords = new ArrayList<>();

    public int[] solution(int n, String[] words) {
        int turn = 1;
        int personNum = 0;
        int[] result = new int[2];
        stackinWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String nowWord = words[i];
            String beforeWord = words[i - 1];
            personNum = i % n + 1;

            if (isNotPassConditions(nowWord, beforeWord)) {
                result[0] = personNum;
                result[1] = turn;
                return result;
            }

            stackinWords.add(nowWord);
            if(personNum == n) turn++; // 인원 다돌면 턴++
        }

        return new int[2]; // 문제 없이 끝말잇기 종료
    }

    /*이미 말한 단어이거나 || 이전 단어의 끝 문자와 현재 단어의 첫 문자가 다른경우*/
    private static boolean isNotPassConditions(String nowWord, String beforeWord){
        if (stackinWords.contains(nowWord) || beforeWord.charAt(beforeWord.length() - 1) != nowWord.charAt(0)) {
            return true;
        }
        return false;
    }

}
