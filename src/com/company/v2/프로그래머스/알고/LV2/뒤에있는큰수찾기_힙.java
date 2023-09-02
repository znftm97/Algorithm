package com.company.v2.프로그래머스.알고.LV2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 뒤에있는큰수찾기_힙 {
    static class Number implements Comparable<Number> {
        int num, idx;
        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.num, o.num);
        }
    }

    public int[] solution(int[] numbers) {
        Queue<Number> pq = new PriorityQueue<>();
        int[] results = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int now = numbers[i];

            while (!pq.isEmpty() && pq.peek().num < now) {
                Number num = pq.poll();
                results[num.idx] = now;
            }

            pq.add(new Number(now, i));
        }

        while (!pq.isEmpty()) {
            Number num = pq.poll();
            results[num.idx] = -1;
        }

        return results;
    }
}
