package com.company.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드합체놀이_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] cards = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(cards);

            long sum = cards[0] + cards[1];
            cards[0] = sum;
            cards[1] = sum;
        }

        long resultSum = 0;
        for (long num : cards) {
            resultSum += num;
        }

        System.out.println(resultSum);
        br.close();
    }

}
