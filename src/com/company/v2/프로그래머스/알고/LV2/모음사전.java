package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 모음사전 {
    static char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    static char[] arr;
    static List<String> words = new ArrayList<>();

    public int solution(String word) {
        arr = new char[5];
        recursion(0);

        int result = 0;
        for(int i = 0; i<words.size(); i++) {
            if(words.get(i).equals(word)) {
                result = i + 1;
                break;
            }
        }

        return result;
    }

    static void recursion(int depth) {
        if(depth == 5) {
            return;
        }

        for(int i = 0; i<5; i++) {
            arr[depth] = alphabets[i];
            add();
            recursion(depth + 1);
            arr[depth] = ' ';
        }
    }

    static void add() {
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            if('A' <= c && c <= 'Z') sb.append(c);
        }

        words.add(sb.toString());
    }
}
