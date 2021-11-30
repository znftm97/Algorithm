package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 단어수학_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] alphabets = new Integer[26];
        Arrays.fill(alphabets, 0);
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int len = s.length();
            int digitOfCount = 1;

            for (int j = 0; j < len-1; j++) {
                digitOfCount *= 10;
            }

            for (int k = 0; k < len; k++) {
                alphabets[s.charAt(k) - 'A'] += digitOfCount;
                digitOfCount /= 10;
            }
        }

        Arrays.sort(alphabets, Collections.reverseOrder());

        int num = 9;
        int sum = 0;
        for (int digit : alphabets) {
            sum += digit*num;
            num--;
        }

        System.out.println(sum);
    }
}
