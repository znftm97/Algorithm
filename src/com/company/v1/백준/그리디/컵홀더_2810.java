package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 컵홀더_2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int count = 1;

        for (int i = 0; i < num; i++) {
            if (s.charAt(i) == 'S') {
                count++;
            } else if (s.charAt(i) == 'L') {
                count++;
                i++;
            }
        }

        if(num > count) {
            System.out.println(count);
        } else {
            System.out.println(num);
        }

        br.close();
    }

}
