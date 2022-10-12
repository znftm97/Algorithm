package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> deletedNodes = new ArrayList<>();
        int leafNode = 0;

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int child = 0; child < N; child++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent != -1) {
                graph.get(parent).add(child);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        q.add(deleteNode);

        while (!q.isEmpty()) {
            int node = q.poll();

            List<Integer> nodes = graph.get(node);
            q.addAll(nodes);

            deletedNodes.add(node);
        }

        for (int i = 0; i < N; i++) {
            if(deletedNodes.contains(i)) {
                continue;
            }

            List<Integer> nodes = graph.get(i);

            if (nodes.isEmpty() || isDeletedChildNodesAll(nodes, deletedNodes)) {
                leafNode++;
            }
        }

        System.out.println(leafNode);
    }

    /*자식 노드가 다 삭제된 노드인경우도 리프노드이므로 확인*/
    private static boolean isDeletedChildNodesAll(List<Integer> nodes, List<Integer> deletedNodes) {
        boolean flag = true;

        for (int node : nodes) {
            if (!deletedNodes.contains(node)) {
                flag = false;
            }
        }

        return flag;
    }

}
