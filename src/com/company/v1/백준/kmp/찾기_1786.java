package com.company.v1.백준.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 찾기_1786 {
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        String origin = br.readLine();
        String pattern = br.readLine();

        int[] pi = getPi(pattern);
        kmp(pi, origin, pattern);

        for (int a : list) {
            sb.append(a).append(" ");
        }

        System.out.println(list.size());
        System.out.println(sb.toString());
    }

    static int[] getPi(String pattern){
        int j = 0;
        int[] pi = new int[pattern.length()];

        for (int i = 1; i < pattern.length(); i++) {
            while (j>0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    static void kmp(int[] pi, String origin, String pattern) {
        int j = 0; // j는 접두사 시작 인덱스

        for (int i = 0; i < origin.length(); i++) { // i는 접미사 시작 인덱스
            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) { // 다르면 같았던 다음 접미사로 바로 건너뛰기
                j = pi[j - 1];
            }

            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) { // j는 접두사 즉 j가 문자열길이만큼 인덱스가 왔다면 origin에서 pattern이 존재한다는 의미
                    list.add(i - pattern.length() + 2);
                    j = pi[j]; // 이후 계속 탐색해야 하므로 초기화
                } else {
                    j++;
                }
            }
        }
    }
}
