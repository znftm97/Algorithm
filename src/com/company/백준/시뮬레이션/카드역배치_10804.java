package com.company.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드역배치_10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] cards = new int[21];
        for (int i = 1; i < 21; i++) {
            cards[i] = i;
        }

        for (int t = 0; t < 10; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int startIdx = x;
            int endIdx = y;
            for (int i = 0; i < (y - x + 1) / 2; i++) {
                int tmp = cards[startIdx];
                cards[startIdx++] = cards[endIdx];
                cards[endIdx--] = tmp;
            }
        }

        for (int i = 1; i < 21; i++) {
            sb.append(cards[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
