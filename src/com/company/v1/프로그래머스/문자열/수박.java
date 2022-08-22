package com.company.v1.프로그래머스.문자열;

public class 수박 {
    public String solution(int n) {
        String waterMelon = "수박";
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                sb.append(waterMelon);
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                sb.append(waterMelon);
            }
            sb.append("수");
        }

        return sb.toString();
    }
}
