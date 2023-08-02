package com.company.v2.소프티어.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지도자동구축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int squareCnt = 1;

        for(int i = 0; i<N; i++){
            squareCnt *= 4;
        }

        System.out.println((int) Math.pow(Math.sqrt(squareCnt) + 1, 2));
    }
}
