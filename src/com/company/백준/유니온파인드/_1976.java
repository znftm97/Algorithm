package com.company.백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 총 개수
        int M = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시 개수

        /*배열 세팅*/
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        /*좌표 하나씩 모두 탐색하면서 1일경우 union 호출해서 합칩합 만들어주기*/
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine()); // 여행계획

        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (start != find(now)) { // 서로 부모가 다르다면 == 연결 안되어있음 == 여행 불가능
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    /*부모 찾기*/
    static int find(int x){
        if(x == parent[x]){ // 자기 자신이 부모인경우
            return x;
        }

        return parent[x] = find(parent[x]); // 아닌경우 재귀를통해 부모찾기
    }

    /*서로 같은 부모 바라보도록*/
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x!=y){ // 서로 다른 부모일때만
            if(x<y){
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}
