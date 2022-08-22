package com.company.v1.백준.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 작업_2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] indegree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        int[] workTime = new int[n + 1];
        int[] result = new int[n+1];
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            workTime[i] = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());

            if (tmp != 0) {
                for (int j = 1; j <= tmp; j++) {
                    graph.get(Integer.parseInt(st.nextToken())).add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            result[i] = workTime[i];

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int nowNode = q.poll();

            for (int nextNode : graph.get(nowNode)) {
                indegree[nextNode]--;
                result[nextNode] = Math.max(result[nextNode], result[nowNode] + workTime[nextNode]);

                if (indegree[nextNode] == 0) {
                    q.add(nextNode);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }
}
