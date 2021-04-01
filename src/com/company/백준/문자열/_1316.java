package com.company.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordCount = Integer.parseInt(br.readLine());
        int groupWordCount = wordCount;

        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();
            boolean[] arr = new boolean[26];

            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) != word.charAt(j + 1)) {
                    if (arr[word.charAt(j + 1) - 97] == true) {
                        groupWordCount--;
                        break;
                    }
                    arr[word.charAt(j) - 97] = true;
                }
            }
        }

        System.out.println(groupWordCount);
    }
}
