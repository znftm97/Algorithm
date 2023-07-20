package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1504 {
    private static List<List<Node>> graph = new ArrayList<>();
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node>{
        int id;
        int cost;

        public Node(int id, int cost){
            this.id=id;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        dist = new int[N+1];

        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y,cost));
            graph.get(y).add(new Node(x,cost));
        }

        st = new StringTokenizer(br.readLine());
        int middleNode1 = Integer.parseInt(st.nextToken());
        int middleNode2 = Integer.parseInt(st.nextToken());

        long result1 = 0;
        result1 += dijkstra(1, middleNode1);
        result1 += dijkstra(middleNode1, middleNode2);
        result1 += dijkstra(middleNode2, N);

        long result2 = 0;
        result2 += dijkstra(1, middleNode2);
        result2 += dijkstra(middleNode2, middleNode1);
        result2 += dijkstra(middleNode1, N);

        if(result1 >= INF && result2 >= INF){
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(result1, result2));
    }

    private static long dijkstra(int startId, int endId){
        Arrays.fill(dist, INF);
        dist[startId] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startId, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.id] < now.cost) continue;

            for(Node next : graph.get(now.id)){
                if(dist[next.id] > now.cost + next.cost){
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Node(next.id, dist[next.id]));
                }
            }
        }

        return dist[endId];
    }
}
