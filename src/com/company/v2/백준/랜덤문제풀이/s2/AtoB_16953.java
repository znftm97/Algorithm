package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targetNum = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int count = 1;

        if (targetNum == num) {
            System.out.println(1);
            return;
        }

        while (true) {
            if (num % 10 == 1) {
                String s = String.valueOf(num);
                s = s.substring(0, s.length() - 1);
                num = Integer.parseInt(s);
            } else if (num % 2 == 1) {
                System.out.println(-1);
                return;
            } else {
                num /= 2;
            }

            count++;

            if (num == targetNum) {
                System.out.println(count);
                return;
            } else if (num < targetNum) {
                System.out.println(-1);
                return;
            }
        }
    }

}
