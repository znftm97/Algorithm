package com.company.v1.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String text = br.readLine();

        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].contains(String.valueOf(text.charAt(i)))) {
                    sum += j;
                }
            }
        }
        System.out.println(sum+text.length());
    }
}
