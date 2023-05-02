package com.company.v2.백준.랜덤문제풀이.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class _2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> CROATIA_ALPHABETS = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        for (String alpha : CROATIA_ALPHABETS) {
            str = str.replaceAll(alpha, "?");
        }

        System.out.println(str.length());
    }
}
