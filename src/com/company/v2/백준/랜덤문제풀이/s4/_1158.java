package com.company.v2.백준.랜덤문제풀이.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int idx = 1;
        while (!q.isEmpty()) {
            if (idx == K) {
                sb.append(q.poll()).append(", ");
                idx = 1;
                continue;
            }

            q.add(q.poll());
            idx++;
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
