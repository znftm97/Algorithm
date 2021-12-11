package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedule, (s1, s2) -> {
            if (s1[0] == s2[0]) {
                return s1[1] - s2[1];
            } else {
                return s1[0] - s2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(schedule[0][1]);

        for (int i = 1; i < N; i++) {
            if(pq.peek() <= schedule[i][0]){
                pq.poll();
            }

            pq.add(schedule[i][1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}
