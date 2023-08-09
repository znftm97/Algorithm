package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {
    private static class Tower {
        int height;
        int idx;

        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Tower> stack = new Stack<>();
        int[] results = new int[N];
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                results[i] = 0;
                stack.add(new Tower(heights[i], i));
                continue;
            }

            if (stack.peek().height < heights[i]) {
                while (!stack.isEmpty()) {
                    if (stack.peek().height < heights[i]) stack.pop();
                    else break;
                }

                if(stack.isEmpty()) results[i] = 0;
                else results[i] = stack.peek().idx + 1;
            } else if (stack.peek().height >= heights[i]) {
                results[i] = stack.peek().idx + 1;
            }

            stack.add(new Tower(heights[i], i));
        }

        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }

}
