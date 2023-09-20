package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493_2 {
    static class Tower {
        int height;
        int idx;
        public Tower(int height, int idx) {
            this.height=height;
            this.idx=idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Tower> stack = new Stack();
        for(int i = 0; i<N; i++) {
            if(stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.add(new Tower(heights[i], i + 1));
                continue;
            }

            if(stack.peek().height >= heights[i]) {
                sb.append(stack.peek().idx).append(" ");
                stack.add(new Tower(heights[i], i + 1));
            } else {
                while (!stack.isEmpty() && stack.peek().height < heights[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(stack.peek().idx).append(" ");
                }
            }

            stack.add(new Tower(heights[i], i + 1));
        }

        System.out.println(sb);
    }
}
