package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _1406_시초 {
    private static int idx;
    private static List<String> list = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int operCnt = Integer.parseInt(br.readLine());
        idx = str.length();

        for (int i = 0; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < operCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            switch (oper) {
                case "L" -> moveLeft();
                case "D" -> moveRight();
                case "B" -> remove();
                case "P" -> add(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    private static void moveLeft() {
        if(idx > 0) idx--;
    }

    private static void moveRight() {
        if(idx < list.size()) idx++;
    }

    private static void remove() {
        if(idx > 0) {
            list.remove(idx - 1);
            idx--;
        }
    }

    private static void add(String addStr) {
        if (idx == list.size()) list.add(addStr);
        else list.add(idx, addStr);

        idx++;
    }
}
