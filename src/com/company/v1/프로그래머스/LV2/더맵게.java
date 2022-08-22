package com.company.v1.프로그래머스.LV2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scovilles, int K) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int scoville : scovilles) {
            pq.add(scoville);
        }

        while (pq.size() > 1){
            int scoville1 = pq.poll();
            int scoville2 = pq.poll();
            if (scoville1 >= K) return result;

            pq.add(scoville1 + (scoville2 * 2));
            result++;
        }

        if (pq.peek() >= K) return result; // 마지막 하나 남은개 K 이상일 경우 예외처리

        return -1; // 마지막 하나 남은개 K 미만이면 불가능
    }

}
