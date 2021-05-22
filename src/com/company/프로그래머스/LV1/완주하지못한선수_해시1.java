package com.company.프로그래머스.LV1;

import java.util.Arrays;

/*그리디? 로 풀기*/
public class 완주하지못한선수_해시1 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i =0;
        /* 끝까지 비교했는데 다 같다면? 배열의 맨끝에 완주못한선수가 있는 경우이다. */
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[i];
    }
}
