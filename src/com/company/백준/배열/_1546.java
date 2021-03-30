package com.company.백준.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        double[] arr = new double[num];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < num; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double sum = 0;
        Arrays.sort(arr);

        for (int i = 0; i < num; i++) {
            sum += (arr[i] / arr[num - 1]) * 100;
        }
        System.out.println(sum/num);
    }
}
