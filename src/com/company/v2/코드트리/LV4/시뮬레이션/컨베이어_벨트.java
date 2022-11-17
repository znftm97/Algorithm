package com.company.v2.코드트리.LV4.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 컨베이어_벨트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        int[] tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q1.addLast(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q2.addFirst(Integer.parseInt(st.nextToken()));
        }

        while (T > 0) {
            q2.addLast(q1.pollLast());
            q1.addFirst(q2.pollFirst());
            T--;
        }

        while (!q1.isEmpty()) {
            sb.append(q1.pollFirst()).append(" ");
        }

        sb.append("\n");

        while (!q2.isEmpty()) {
            sb.append(q2.pollLast()).append(" ");
        }

        System.out.println(sb);
    }

}
