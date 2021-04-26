package com.company.백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603 {
    static int numCount; // 집합의 숫자 개수
    static int[] arr; // 선택한 숫자 집합 배열
    static int[] result; // 선택한 숫자집합 중, 로또 번호로 사용할 숫자의 값을 1로 설정하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            numCount = Integer.parseInt(st.nextToken());
            if (numCount == 0) { // 0 입력시 무한반복문 탈출 후 종료
                break;
            }
            arr = new int[numCount];
            result = new int[numCount];

            for (int i = 0; i < numCount; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            System.out.println();
        }
    }

    public static void dfs(int start, int depth) {
        /*재귀 탈출문, 로또번호는 6개이므로 depth 가 6일때 result 배열의 값이 1인 경우, arr 배열의 값 출력*/
        if (depth == 6) {
            for (int i = 0; i < numCount; i++) {
                if (result[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < numCount; i++) {
            result[i] = 1; // 방문한 요소 값을 1로 설정
            dfs(i+1, depth+1);

            result[i] = 0; // 재귀 호출이 끝나면 다시 0으로 설정
        }
    }
}
