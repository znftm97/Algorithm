package com.company.백준.기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 방번호_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("");
        int[] check = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if(num==9) {
                num = 6;
            }
            check[num]++;
        }

        /*홀수 일때 +1*/
        check[6] = check[6]/2 + check[6]%2;

        Arrays.sort(check);
        System.out.println(check[9]);

    }
}
