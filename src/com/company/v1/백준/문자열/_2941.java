package com.company.v1.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String text = br.readLine();

        for (int i = 0; i < arr.length; i++) {
            text = text.replaceAll(arr[i], "@");
        }

        System.out.println(text.length());
    }
}