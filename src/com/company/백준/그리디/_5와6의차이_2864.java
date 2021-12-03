package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5와6의차이_2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String a = st.nextToken();
        String b = st.nextToken();

        String minA = a.replace('6', '5');
        String minB = b.replace('6', '5');
        sb.append(Integer.parseInt(minA) + Integer.parseInt(minB)).append(" ");


        String maxA = a.replace('5', '6');
        String maxB = b.replace('5', '6');
        sb.append(Integer.parseInt(maxA) + Integer.parseInt(maxB));

        System.out.println(sb);
        br.close();
    }
}
