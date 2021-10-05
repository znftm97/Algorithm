package com.company.백준.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬_10174_팰린드롬판별 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String input = br.readLine();
            String str = input.toLowerCase();

            int startIndex = 0;
            int endIndex = str.length() - 1;

            while (true) {
                if (startIndex >= endIndex) {
                    sb.append("Yes").append("\n");
                    break;
                } else if (str.charAt(startIndex) == str.charAt(endIndex)) {
                    startIndex++;
                    endIndex--;
                } else {
                    sb.append("No").append("\n");
                    break;
                }
            }

        }

        System.out.println(sb);

    }
}
