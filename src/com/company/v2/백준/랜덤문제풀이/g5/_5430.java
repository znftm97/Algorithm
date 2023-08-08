package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _5430 {
    private static Deque<Integer> dq = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            char[] opers = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            dq = parseStringToDeque(br.readLine(), N);
            boolean hasError = false;
            boolean isHead = true;

            for (int i = 0; i < opers.length; i++) {
                if (opers[i] == 'R') {
                    isHead = !isHead;
                } else {
                    if(dq.isEmpty()) {
                        hasError = true;
                        break;
                    }
                    removeFirst(isHead);
                }
            }

            if (hasError) {
                System.out.println("error");
                continue;
            }

            print(isHead);
        }
    }

    private static Deque<Integer> parseStringToDeque(String arr, int N) {
        arr = arr.substring(1, arr.length() - 1);
        StringTokenizer st = new StringTokenizer(arr, ",");

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            dq.add(Integer.parseInt(st.nextToken()));
        }

        return dq;
    }

    private static void removeFirst(boolean isHead) {
        if(isHead) dq.pollFirst();
        else dq.pollLast();
    }

    private static void print(boolean isHead) {
        if (dq.isEmpty()) {
            System.out.println("[]");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (isHead) {
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst()).append(",");
            }
        } else {
            while (!dq.isEmpty()) {
                sb.append(dq.pollLast()).append(",");
            }
        }

        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb);
    }
}
