package com.company.v2.프로그래머스.알고.LV3;

import java.util.*;

public class 부대복귀 {
    static List<List<Node>> graph = new ArrayList<>();
    static Map<Integer, Integer> nodeToTimeMap = new HashMap<>();
    static boolean[] visited;
    static Set<Integer> sourceNodes = new HashSet<>();

    static class Node {
        int id,cost;
        public Node(int id, int cost) {
            this.id=id;
            this.cost=cost;
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        visited = new boolean[n + 1];
        for(int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int source : sources) {
            sourceNodes.add(source);
        }

        for(int[] road : roads) {
            int x = road[0];
            int y = road[1];
            graph.get(x).add(new Node(y,0));
            graph.get(y).add(new Node(x,0));
        }

        bfs(destination);

        int[] results = new int[sources.length];
        for(int i = 0; i<results.length; i++) {
            if(nodeToTimeMap.containsKey(sources[i])) {
                results[i] = nodeToTimeMap.get(sources[i]);
            } else {
                results[i] = -1;
            }
        }

        return results;
    }

    static void bfs(int dest) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(dest, 0));
        visited[dest] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(sourceNodes.contains(now.id)) {
                nodeToTimeMap.put(now.id, now.cost);
            }

            for(Node next : graph.get(now.id)) {
                if(!visited[next.id]) {
                    q.add(new Node(next.id, now.cost + 1));
                    visited[next.id] = true;
                }
            }
        }
    }
}
