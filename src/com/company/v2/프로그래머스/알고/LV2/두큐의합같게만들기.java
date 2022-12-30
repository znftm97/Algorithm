package com.company.v2.프로그래머스.알고.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐의합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;
        int cnt = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);

            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }

        while (true) {
            if (cnt > queue1.length * 3) {
                return -1;
            }

            if (q1Sum == q2Sum) {
                return cnt;
            }

            if (q1Sum > q2Sum) {
                int num = q1.poll();
                q1Sum -= num;
                q2Sum += num;

                q2.add(num);
                cnt++;
            } else if (q1Sum < q2Sum) {
                int num = q2.poll();
                q2Sum -= num;
                q1Sum += num;

                q1.add(num);
                cnt++;
            }
        }
    }

}
