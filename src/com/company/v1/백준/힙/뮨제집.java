package com.company.v1.백준.힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 뮨제집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int problemCount = Integer.parseInt(st.nextToken());
        int preProblemCount = Integer.parseInt(st.nextToken());
        int[][] arr = new int[preProblemCount][2];

        for (int i = 0; i < preProblemCount; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < preProblemCount; i++) {
            pq.add(arr[i]);
        }

        for (int i = 0; i < preProblemCount; i++) {
            int[] poll = pq.poll();
            for (int j = 0; j < poll.length; j++) {
                sb.append(poll[j]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
