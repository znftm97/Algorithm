package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> nums = new PriorityQueue<>((o1, o2) -> {
            int n1 = Math.abs(o1);
            int n2 = Math.abs(o2);

            if(n1 == n2){
                return o1 > o2 ? 1 : -1;
            }

            return n1 - n2;
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (nums.isEmpty()) sb.append("0").append("\n");
                else sb.append(nums.poll()).append("\n");
            } else {
                nums.add(num);
            }
        }

        System.out.println(sb);
    }

}
