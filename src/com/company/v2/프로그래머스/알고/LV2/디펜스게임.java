package com.company.v2.프로그래머스.알고.LV2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = enemy.length;

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    result = i;
                    break;
                }
            }
        }

        return result;
    }
}
