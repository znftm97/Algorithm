package com.company.v1.백준.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] alphabets = new int[26];

        for (int i = 0; i < str.length(); i++) { // 1. 알파벳 개수 카운팅
            alphabets[str.charAt(i) - 'A']++;
        }

        int oddNumCount = 0;
        int oddNumIndex = -1;
        for (int i = 0; i < 26; i++) { // 2. 개수가 홀수인 알파벳 개수 카운팅
            if(alphabets[i] % 2 == 1) {
                oddNumCount++;
                oddNumIndex = i;
            }
        }

        if(oddNumCount >= 2 || (oddNumCount == 1 && str.length() % 2 == 0)) { // 3. 팰린드롬 못만드는 경우
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 4. 팰린드롬 만들기
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabets[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }
        String reverseStr = (new StringBuilder()).append(sb).reverse().toString();

        if (oddNumCount == 1) sb.append((char)(oddNumIndex + 'A')); // 개수가 홀수인 알파벳이 있다면 무조건 문자열의 가운데에 위치해야 팰린드롬 만족

        sb.append(reverseStr);
        System.out.println(sb);
    }
}
