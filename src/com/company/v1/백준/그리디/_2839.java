package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        if (sugar == 4 || sugar == 7) {
            System.out.println(-1);
        }
        else if (sugar % 5 == 0) {
            System.out.println(sugar / 5);
        }
        else if (sugar % 5 == 1 || sugar % 5 == 3) {
            System.out.println((sugar / 5) + 1);
        }
        else if (sugar % 5 == 2 || sugar % 5 == 4) {
            System.out.println((sugar / 5) + 2);
        }
    }
}
