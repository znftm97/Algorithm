package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1406 {
    private static Stack<String> leftStack = new Stack<>();
    private static Stack<String> rightStack = new Stack<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int operCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            leftStack.add(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < operCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            switch (oper) {
                case "L" : moveLeft(); break;
                case "D" : moveRight(); break;
                case "B" : remove(); break;
                case "P" : add(st.nextToken()); break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        while (!rightStack.isEmpty()) sb.append(rightStack.pop());
        System.out.println(sb);
    }

    private static void moveLeft() {
        if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
    }

    private static void moveRight() {
        if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
    }

    private static void remove() {
        if(!leftStack.isEmpty()) leftStack.pop();
    }

    private static void add(String addStr) {
        leftStack.push(addStr);
    }
}
