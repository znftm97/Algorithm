package com.company.백준.완전탐색.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888 {
    static int numCount;
    static int[] op = new int[4];
    static int[] arr;
    /*MAX 에 MIN_VALUE 값을 주는 이유는 dfs 메서드에서 MATH.max 메서드 사용시, 파라미터로 전달된 값들 중 MAX_VALUE와 가까운 값을 리턴해주기 때문이다.*/
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numCount = Integer.parseInt(br.readLine());
        arr = new int[numCount];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) {
        /*재귀 탈출문, 인덱스(idx)가 숫자의 개수와 같으면(한 연산자로 모든 수를 연산 후) max,min 메서드로 최대값 최소값 저장*/
        /*max, min 메서드는 내부에 삼항연산자로 구현되있어 더 큰값을 return 해줌*/
        if (idx == numCount) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        /*재귀 호출문, 연산자 개수 만큼 반복문 수행*/
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) { // 연산자의 개수가 하나라도 존재해야 됨
                op[i]--; // 연산자 개수 감소

                /*재귀 호출시 인덱스값 증가해서 호출*/
                switch (i) {
                    case 0:	dfs(num + arr[idx], idx + 1);	break;
                    case 1:	dfs(num - arr[idx], idx + 1);	break;
                    case 2:	dfs(num * arr[idx], idx + 1);	break;
                    case 3:	dfs(num / arr[idx], idx + 1);	break;
                }

                op[i]++; // 재귀호출 끝나면 연산자 개수 복구
            }
        }
    }
}
