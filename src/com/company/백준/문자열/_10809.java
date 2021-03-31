package com.company.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for (char a = 'a'; a <= 'z'; a++) {
            System.out.print(s.indexOf(a) + " ");
        }
    }
}
