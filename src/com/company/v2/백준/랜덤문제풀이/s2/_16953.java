package com.company.v2.백준.랜덤문제풀이.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16953 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        if(A.equals("B")) {
            System.out.println(1);
            return;
        }

        int cnt = 1;
        while (true) {
            int a = Integer.parseInt(A);
            int b = Integer.parseInt(B);

            if (A.equals(B)) {
                break;
            }

            if (b < a) {
                cnt = -1;
                break;
            }

            if (b % 10 == 1) B = B.substring(0, B.length() - 1);
            else if(b % 2 == 0) B = String.valueOf(b / 2);
            else {
                cnt = -1;
                break;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
