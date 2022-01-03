package com.company.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 접미사배열_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> suffixes = new ArrayList<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            suffixes.add(s.substring(i));
        }

        Collections.sort(suffixes);
        for (String str : suffixes) {
            System.out.println(str);
        }
        br.close();
    }

}
