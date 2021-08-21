package com.company.백준.기타.실4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소인수분해_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        if (n <= 99) {
            System.out.println(n);
            return;
        }

        for (int i = 100; i <= n; i++) {
            String s = String.valueOf(i);

            if ((s.charAt(1) - s.charAt(0)) == (s.charAt(2) - s.charAt(1))) {
                count++;
            }
        }

        System.out.println(count+99);
    }
}
