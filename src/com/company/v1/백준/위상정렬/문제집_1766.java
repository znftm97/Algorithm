package com.company.v1.백준.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제집_1766 {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        topologicalSort(indegree, graph);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> graph) {
        /*문제 3번째 조건에서 가능한 쉬운문제(작은 수) 부터 풀어야한다는 조건을 만족해야 한다.
         * 그렇다는건 q에 들어가는 노드들을 작은 수 부터 꺼내오면 된다. 즉 오름차순 정렬을 하면되기 때문에 우선순위 큐를 사용한다.
         *
         * 우선순위 큐 사용 안했을 때
         *    q   : 3,4 -> 4,1 ->  1 ->    2   ->
         * result :     ->  3  -> 3,4 -> 3,4,1 -> 3,4,1,2
         * 우선순위 큐 사용
         *    q   : 3,4 -> 1,4 ->  4  ->   2   ->
         * result :     ->  3  -> 3,1 -> 3,1,4 -> 3,1,4,2
         * */
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (Integer target : graph.get(node)) {
                indegree[target]--;

                if (indegree[target] == 0) {
                    q.add(target);
                }
            }
        }

        while (!result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
