package com.company.v1.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class _1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrI = new int[26];

        String text = br.readLine().toUpperCase(Locale.ROOT);

        for (int i = 0; i < text.length(); i++) {
            arrI[text.charAt(i) - 65]++;
        }

        Integer[] transArr = Arrays.stream(arrI).boxed().toArray(Integer[]::new);

        Arrays.sort(transArr, Collections.reverseOrder());
        if(transArr[0].equals(transArr[1])){
            System.out.println("?");
        } else {
            System.out.println(transArr[0]);
        }
    }
}
