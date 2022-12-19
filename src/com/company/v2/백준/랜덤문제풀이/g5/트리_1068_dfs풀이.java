package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리_1068_dfs풀이 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visit;
    private static int leafNode, deleteNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        int rootNode = 0;

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int child = 0; child < N; child++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent != -1) {
                graph.get(parent).add(child);
            } else {
                rootNode = child;
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == rootNode) {
            System.out.println(0);
            return;
        }

        dfs(rootNode);

        System.out.println(leafNode);
    }

    private static void dfs(int node) {

        visit[node] = true;
        int childCnt = 0;

        for (int i = 0; i < graph.get(node).size(); i++) {
            int childNode = graph.get(node).get(i);

            if (!visit[childNode] && childNode != deleteNode) {
                childCnt++;
                dfs(childNode);
            }
        }

        if (childCnt == 0) {
            leafNode++;
        }
    }

}
