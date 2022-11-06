package com.company.v2.코드트리.프로그래밍연습.완탐1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이상한진수2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        boolean hasZero = false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                hasZero = true;
            }
        }

        if (hasZero) {
            a = a.replaceFirst("0", "1");
        } else {
            a = a.substring(0, a.length() - 1) + "0";
        }

        System.out.println(Integer.valueOf(a, 2));
    }

}
