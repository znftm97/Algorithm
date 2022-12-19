package com.company.v1.백준.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            hSet.add( Integer.parseInt(br.readLine()) % 42 );
        }

        System.out.println(hSet.size());
    }
}
