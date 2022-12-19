package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이_15903_우선순위큐이용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long firstMinNum = cards.poll();
            long secondMinNum = cards.poll();

            long sum = firstMinNum + secondMinNum;
            cards.add(sum);
            cards.add(sum);
        }

        long resultSum = 0;
        for (long num : cards) {
            resultSum += num;
        }

        System.out.println(resultSum);
        br.close();
    }

}
