package com.company.v1.프로그래머스.스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int max = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int w : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.offer(w);
                    max += w;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) {
                    max -= q.poll();
                } else {
                    if( max + w > weight) {
                        q.offer(0);
                        answer++;
                    } else {
                        q.offer(w);
                        max += w;
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
