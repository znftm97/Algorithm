package com.company.v1.프로그래머스.Etc;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
