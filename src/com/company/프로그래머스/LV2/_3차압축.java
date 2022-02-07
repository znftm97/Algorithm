package com.company.프로그래머스.LV2;

import java.util.ArrayList;
import java.util.List;

public class _3차압축 {
    public List<Integer> solution(String msg){
        List<String> dictionary = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        /*1. 사전 만들기 */
        char alphabet = 'A';
        for (int i = 0; i < 26; i++) {
            dictionary.add(String.valueOf(alphabet++));
        }

        for (int i = 0; i < msg.length(); i++) {
            String word = String.valueOf(msg.charAt(i));
            int nextIndex = i + 1;

            /*2. 현재 입력과 일치하는 가장 긴 문자열찾기 */
            while (nextIndex <= msg.length() - 1) {
                String nextChar = String.valueOf(msg.charAt(nextIndex));

                if (dictionary.contains(word + nextChar)) {
                    word += nextChar;
                    i++;
                    nextIndex++;
                } else {
                    dictionary.add(word + nextChar); // 4. 새 단어 색인 등록
                    break;
                }
            }

            result.add(dictionary.indexOf(word) + 1); // 3. 색인 저장
        }

        return result;
    }

}
