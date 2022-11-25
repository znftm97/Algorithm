package com.company.v2.코드트리.LV4.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아름다운수 {
    private static int N, result;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        recursion(0);

        System.out.println(result);
    }

    private static void recursion(int depth) {
        if (depth == N) {
            if (isBeautifulNum()) {
                result++;
            }

            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            recursion(depth + 1);
        }
    }

    private static boolean isBeautifulNum() {
        for(int i = 0; i < N; i += arr[i]) {
            if (i + arr[i] - 1 >= N) {
                return false;
            }

            for (int j = i; j < i + arr[i]; j++) {
                if (arr[j] != arr[i]) {
                    return false;
                }
            }
        }

        return true;
    }

}
