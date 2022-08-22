package com.company.v1.프로그래머스.문자열;


public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) { // 문자열 길이 만큼
            char c = s.charAt(i);

            if (c == ' ') { // 공백은 패스
                sb.append(' ');
                continue;
            }

            for (int j = 0; j < n; j++) { // n번 반복
                if (c == 'z') {
                    c = 'a';
                    continue;
                } else if (c == 'Z') {
                    c = 'A';
                    continue;
                }
                c = (char) (c + 1);
            }
            sb.append(c);
        }

        return sb.toString();
    }
}

