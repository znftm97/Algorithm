package com.company.백준.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프_1707 {
    private static List<List<Integer>> graph;
    private static int[] color;
    private static final int RED = 1;
    private static final int BLUE = -1;
    private static String result = "YES";

    private static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = RED;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int connectedNode : graph.get(node)) {
                if (color[node] == color[connectedNode]) { // 인접 노드가 같은 색인경우 == 이분 그래프가 아니다
                    result = "NO";
                    return false;
                } else if (color[connectedNode] == 0) { // 처음 방문한 노드인 경우
                    q.add(connectedNode);
                    color[connectedNode] = color[node] * -1;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            result = "YES";
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            color = new int[V + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for (int i = 1; i <= V; i++) { // 그래프가 여러개로 나눠져 있는 경우를 위해 반복문
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        break;
                    }
                }
            }

            System.out.println(result);
        }

        br.close();
    }

}
