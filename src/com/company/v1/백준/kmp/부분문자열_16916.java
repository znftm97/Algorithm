package com.company.v1.백준.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String origin = br.readLine();
        String pattern = br.readLine();

        int[] pi = getPi(pattern);
        kmp(pi, origin, pattern);
    }

    static int[] getPi(String pattern){
        int j = 0;
        int[] pi = new int[pattern.length()];

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    static void kmp(int[] pi, String origin, String pattern) {
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    System.out.println(1);
                    return;
                } else {
                    j++;
                }
            }
        }

        System.out.println(0);
    }
}
