package com.company.v2.백준.라이브코딩준비b1_s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분수합_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int resultA = (a1 * b2) + (a2 * b1);
        int resultB = b1 * b2;

        while (true) {
            boolean flag = true;

            for (int i = 2; i <= resultB; i++) {
                if (resultA % i == 0 && resultB % i == 0) {
                    resultA /= i;
                    resultB /= i;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        System.out.println(resultA + " " + resultB);
    }

}
