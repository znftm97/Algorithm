package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거짓말_1043 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());
        parent = new int[people + 1];

        for (int i = 1; i <= people; i++) {
            parent[i] = i;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < party; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int truthPeopleCnt = Integer.parseInt(st.nextToken());
        boolean[] truthPeople = new boolean[51];

        for (int i = 0; i < truthPeopleCnt; i++) {
            truthPeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 그룹화 && 그래프 그리기
        for (int i = 0; i < party; i++) {
            st = new StringTokenizer(br.readLine());
            int participatePeople = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            graph.get(i).add(node);

            for (int j = 0; j < participatePeople - 1; j++) {
                int nextNode = Integer.parseInt(st.nextToken());
                union(node, nextNode);
                graph.get(i).add(nextNode);
                node = nextNode;
            }
        }

        // 진실을 아는 사람들의 부모도 체크
        for (int i = 1; i <= people; i++) {
            if (truthPeople[i]) {
                truthPeople[find(i)] = true;
            }
        }

        // 거짓말할 수 있는 파티 카운팅
        int result = 0;
        for (List<Integer> list : graph) {
            int parent = find(list.get(0));

            if (!truthPeople[parent]) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }

}
