package com.company.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 평범한배낭_12865_그리디안풀림 {
    private static class Product implements Comparable<Product> {
        int weight;
        int value;
        double efficiency;

        public Product(int weight, int cost, double efficiency) {
            this.weight = weight;
            this.value = cost;
            this.efficiency = efficiency;
        }

        @Override
        public int compareTo(Product c) {
            if (Double.compare(this.efficiency, c.efficiency) == 0) {
                return Integer.compare(this.weight, c.weight);
            }

            return Double.compare(this.efficiency, c.efficiency);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            products.add(new Product(w, v, (double) w / v));
        }

        Collections.sort(products);

        int sumWeight = 0;
        int result = 0;
        for (Product p : products) {
            if (sumWeight + p.weight <= K) {
                result += p.value;
                sumWeight += p.weight;
            }
        }

        System.out.println(result);
    }

}
