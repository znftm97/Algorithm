package com.company.v2.백준.랜덤문제풀이.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1315 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        for (String word : words) {
            boolean[] check = new boolean[26];
            boolean isGroupWord = true;

            for (int i = 0; i < word.length() - 1; i++) {
                char nowC = word.charAt(i);
                char nextC = word.charAt(i + 1);

                if (check[nowC - 'a']) {
                    isGroupWord = false;
                    break;
                }

                if (nowC != nextC) {
                    check[nowC - 'a'] = true;
                }
            }

            if(check[word.charAt(word.length()-1) - 'a']) isGroupWord = false;
            if(isGroupWord) result++;
        }

        System.out.println(result);
    }
}
