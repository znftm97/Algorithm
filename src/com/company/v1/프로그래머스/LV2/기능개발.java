package com.company.v1.프로그래머스.LV2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (true) {
            if(index >= progresses.length) break;

            for (int i = index; i < progresses.length; i++) { // 이미 완료된 기능은 계산 필요 없으니 index 부터 계산
                progresses[i] += speeds[i];
            }

            int cnt = 0;
            if (progresses[index] >= 100) {
                for (int i = index; i < progresses.length; i++) { // 이미 완료된 기능은 카운팅하면 안되니 index 부터 탐색
                    if(progresses[i] >= 100) {
                        cnt++;
                        index++;
                    }
                    else break;
                }

                result.add(cnt);
            }
        }

        return result;
    }

}
