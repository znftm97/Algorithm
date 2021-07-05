package com.company.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {
    static int pi[];
    static String origin, pattern;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();
        pattern = br.readLine();

        pi = new int[pattern.length()];
        getPi();
        kmp();
    }

    static void getPi() {
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            /*i,j가 맞는 위치가 나올때 까지 j-1칸의 공통 부분 위치로 이동*/
            while (j>0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    static void kmp() {
        int j = 0;
        for (int i = 0; i < origin.length(); i++) {
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    System.out.println("찾음");
                    break;
                } else {
                    j++;
                }
            }
        }
    }
}
