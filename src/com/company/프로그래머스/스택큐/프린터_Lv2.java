package com.company.프로그래머스.스택큐;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*우선순위 큐 사용*/
public class 프린터_Lv2 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순으로 정렬

        /*큐에 우선순위 입력 내림차순으로 정렬됨*/
        for (int i : priorities) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) { // queue.peek() 값은 제일 먼저 빠져나가야 하는 문서의 우선순위, 해당 우선순위와 배열의 값이 같으면 출력(poll)
                    if (location == i) {
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }
}
