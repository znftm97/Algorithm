package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1759 {
    static int N, C;
    static String[] alphabets;
    static String[] copyAlphabets;
    static StringBuilder sb = new StringBuilder();
    static Set<String> moeums = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new String[C];
        copyAlphabets = new String[C];
        moeums.add("a");
        moeums.add("e");
        moeums.add("i");
        moeums.add("o");
        moeums.add("u");

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabets[i] = st.nextToken();
        }

        Arrays.sort(alphabets);

        recursion(0, 0);
        System.out.println(sb);
    }

    static void recursion(int start, int depth) {
        if (depth == N) {
            if (isPassword()) {
                print();
            }

            return;
        }

        for (int i = start; i < C; i++) {
            copyAlphabets[depth] = alphabets[i];
            recursion(i + 1, depth + 1);
        }
    }

    static boolean isPassword() {
        int moeum = 0;
        int jaeum = 0;

        for (String s : copyAlphabets) {
            if(s == null) continue;

            if(moeums.contains(s)) moeum++;
            else jaeum++;
        }

        return moeum >= 1 && jaeum >= 2;
    }

    static void print() {
        for (String s : copyAlphabets) {
            if(s != null) sb.append(s);
        }
        sb.append("\n");
    }
}
