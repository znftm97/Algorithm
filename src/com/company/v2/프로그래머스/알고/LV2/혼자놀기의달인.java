package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 혼자놀기의달인 {
    public int solution(int[] cards) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] visited = new boolean[cards.length];

        for(int i = 0; i<cards.length; i++) {
            if(visited[i]) continue;

            int card = cards[i];
            int cnt = 0;

            while(true) {
                if(visited[card - 1]) break;

                cnt++;
                visited[card - 1] = true;
                card = cards[card - 1];
            }

            pq.add(cnt);
        }

        return pq.size() <= 1 ? 0 : pq.poll() * pq.poll();
    }
}
