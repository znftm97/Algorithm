package com.company.백준.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄세우기_2252 {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n + 1]; // 해당 노드를 가리키는 간선 개수를 담음
        List<List<Integer>> graph = new ArrayList<>(); // 그래프의 관계를 표현하기 위한 그래프

        /*문제에서 1부터 입력받기 때문에 n+1, 학생 수 즉 노드의 개수 만큼 생성*/
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        /*노드끼리 연결, 각 노드의 간선 개수 카운팅*/
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
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        /*indegree가 0인 노드 q에 삽입, 즉 노드 자신을 가리키는 간선이 없을 때
         * 1부터 입력 시작이라 indegree[0]는 무조건 0이므로 1부터 시작
         * */
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            /*q에서 뽑은 node가 가리키는 노드(target)들의 indegree값을 감소시키고, 만약 0이됬다면 q에 추가*/
            for (Integer target : graph.get(node)) {
                indegree[target]--;

                /*0이되서 자기를 가리키는 간선이 없다면 q에 추가*/
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
