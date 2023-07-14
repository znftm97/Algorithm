package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1707 {
    private static List<List<Integer>> graph;
    private static int[] colors;
    private static String result = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            result = "YES";
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());
            colors = new int[nodeCnt + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= nodeCnt; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < edgeCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for (int i = 1; i <= nodeCnt; i++) {
                if (colors[i] == 0) {
                    if (!isBinaryGraph(i)) {
                        break;
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static boolean isBinaryGraph(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nextNode : graph.get(node)) {
                if (colors[node] == colors[nextNode]) {
                    result = "NO";
                    return false;
                } else if(colors[nextNode] == 0) {
                    q.add(nextNode);
                    colors[nextNode] = colors[node] * -1;
                }
            }
        }

        return true;
    }
}
