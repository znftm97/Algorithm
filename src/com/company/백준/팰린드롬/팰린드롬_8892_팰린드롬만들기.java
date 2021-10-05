package com.company.백준.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬_8892_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            boolean check = false;

            for (int i = 0; i < N; i++) arr[i] = br.readLine();

            loop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    String str = "";

                    if(i != j) { // 같은 문자를 두 번 더하면 안됨, 서로 다른 문자들만 더해야 함
                        str = (new StringBuilder()).append(arr[i]).append(arr[j]).toString(); // 문자열을 더할땐 StringBuilder 지향, 물론 + 연산자 사용해도 자동으로 StringBuilder 호출해줌
                    }                                                                         // 하지만 매 줄마다 또는 반복문으로 반복호출하는 경우, + 연산자도 새 String 객체가 할당되므로, 주관적으론 그냥 모든 상황에서 StringBuilder 쓰는걸 지향

                    if (isPalindrome(str)) {
                        sb.append(str).append("\n");
                        check = true;
                        break loop;
                    }
                }
            }

            if (!check) {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);

    }

    public static boolean isPalindrome(String str) {
        int startIndex = 0;
        int endIndex = str.length() - 1;

        while (true) {
            if (startIndex >= endIndex) {
                return true;
            } else if (str.charAt(startIndex) == str.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
    }
}
