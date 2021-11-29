package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _30_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        String s = br.readLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for (int i = chars.length - 1; i >= 0; i--) {
            int num = chars[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (chars[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }

}
