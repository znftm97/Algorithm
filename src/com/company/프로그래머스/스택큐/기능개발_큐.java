package com.company.프로그래머스.스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발_큐 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }
            q.add(count);
            count = 0;
        }

        while (!q.isEmpty()) {
            int tmp = q.poll();
            int toCount = 1;

            while (true) {
                if (!q.isEmpty() && tmp >= q.peek()) {
                    q.poll();
                    toCount++;
                } else {
                    break;
                }
            }

            answer.add(toCount);
        }

        int[] realAnswer = new int[answer.size()];
        int tmp = 0;
        for (int a : answer) {
            realAnswer[tmp++] = a;
        }

        return realAnswer;
    }
}
