package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 크게만들기_2812_시간초과 {
    private static int K = 0;

    private static void back(int[] num, int index){
        int subIndex = index - 1;
        while (true) {
            if (K <= 0 || subIndex <= -1) {
                break;
            }

            if (num[subIndex] == -1) {
                subIndex--;
                continue;
            }

            if (num[index] > num[subIndex]) {
                num[subIndex] = -1;
                subIndex--;
                K--;
            } else if (num[index] < num[subIndex]) {
                subIndex--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int[] num = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i) - '0';
        }

        int index = 0;
        while (true) {
            if (K <= 0 || index == num.length - 1) {
                break;
            }

            if (num[index] < num[index + 1]) {
                num[index] = -1;
                index++;
                K--;
                back(num, index);
            } else if (num[index] >= num[index + 1]) {
                index++;
            }
        }

        for (int n : num) {
            if (n != -1) {
                sb.append(n);
            }
        }

        System.out.println(sb);
        br.close();
    }

}
