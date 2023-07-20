package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1753 {
    private static int[] dist;
    private static List<List<Node>> graph = new ArrayList<>();
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

        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startNodeId = Integer.parseInt(br.readLine());

        dist = new int[nodeCnt + 1];
        Arrays.fill(dist, INF);
        dist[startNodeId] = 0;

        for(int i = 0; i<=nodeCnt; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<lineCnt; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, cost));
        }

        dijkstra(startNodeId);

        for(int i = 1; i < dist.length; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int startNodeId){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNodeId, 0));

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            if(dist[nowNode.id] < nowNode.cost) continue;

            for(Node nextNode : graph.get(nowNode.id)){
                if(dist[nextNode.id] > nowNode.cost + nextNode.cost){
                    dist[nextNode.id] = nowNode.cost + nextNode.cost;
                    pq.add(new Node(nextNode.id, dist[nextNode.id]));
                }
            }
        }
    }
}
