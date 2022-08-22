package com.company.v1.프로그래머스.문자열;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
                break;
            }
        }

        return "김서방은 " + index + "에 있다";
    }
}
