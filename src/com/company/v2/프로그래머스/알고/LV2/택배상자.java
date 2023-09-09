package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 택배상자 {
    public int solution(int[] order) {
        Queue<Integer> belt = new LinkedList<>();
        Stack<Integer> subBelt = new Stack();

        for(int i = 1; i<=order.length; i++) {
            belt.add(i);
        }

        int idx = 0;
        int result = 0;
        while(true) {
            int target = order[idx];

            if(!belt.isEmpty() && belt.peek() == target) {
                belt.poll();
                result++;
                idx++;
            } else if (!subBelt.isEmpty() && subBelt.peek() == target) {
                subBelt.pop();
                result++;
                idx++;
            } else if (!belt.isEmpty() && belt.peek() != target) {
                subBelt.add(belt.poll());
            } else {
                break;
            }

            if(idx >= order.length) break;
        }

        return result;
    }

    public int solution2(int[] order) {
        Stack<Integer> subBelt = new Stack();
        int idx = 0;

        for(int i = 0; i<order.length; i++) {
            subBelt.add(i + 1);

            while(!subBelt.isEmpty()) {
                if(subBelt.peek() == order[idx]) {
                    subBelt.pop();
                    idx++;
                } else break;
            }
        }

        return idx;
    }
}
