package com.company.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            String p = st.nextToken();

            for (int j = 0; j < p.length(); j++) {
                for (int z = 0; z < r; z++) {
                    System.out.print(p.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
