package com.company.백준.완전탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649 {
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    /*depth 는 배열의 인덱스 값으로 활용 + 길이를 넘지 않도록 M값과 비교하여 조건으로 활용 */
    public static void dfs(int depth) {
        /*재귀 탈출문으로 depth 가 길이 M과 같다면 배열에 쌓인 수를 StringBulider에 추가*/
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        /*재귀호출문으로, 중복이 없어야 하므로 방문하지 않은 노드만 실행*/
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true; // 해당 노드를 방문상태로 변경
                arr[depth] = i + 1;
                dfs(depth + 1); // 다음 노드를 방문하기 위해 +1

                visit[i] = false; // 자식노드 방문이 끝나고(마지막 재귀호출이 끝나고) 다시 false 방문하지 않은 상태로 변경
            }
        }
    }
}
