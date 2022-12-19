package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cityCount = Integer.parseInt(br.readLine());
        long[] distance = new long[cityCount - 1];
        long[] price = new long[cityCount];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cityCount - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cityCount; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < cityCount - 1; i++) {
            if (price[i] < price[i + 1]) {
                price[i + 1] = price[i];
            }

            sum += price[i] * distance[i];
        }

        System.out.println(sum);
    }
}
