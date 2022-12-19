package com.company.v1.동빈북.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의법칙_다른풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int maxIndex = n-1;
        int beforeMaxIndex = n-2;
        int patternSum = (arr[maxIndex] * k) + arr[beforeMaxIndex]; // 반복되는 패턴 수의 합
        int patternRepeatCount = m / (k + 1); // 패턴이 반복되는 횟수

        int tmp = m % (k+1); // 패턴과 더해야 하는 횟수(m)가 나누어 떨어지는지
        if (tmp == 0) {
            result = patternSum * patternRepeatCount;
        } else {
            result = (patternSum * patternRepeatCount) + (arr[maxIndex] * tmp);
        }

        System.out.println(result);
    }

}
