package com.company.v1.코드트리.알고리즘기본.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*클래스로 구현하는 게 더 깔끔할듯*/
public class 쪼개어배낭채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double[][] arr = new double[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            double w = Integer.parseInt(st.nextToken());
            double v = Integer.parseInt(st.nextToken());

            arr[i][0] = w; // 무게
            arr[i][1] = v; // 가격
            arr[i][2] = v / w; // 무게당 가격
        }

        /*소수점 계산해야되서 if문으로 분기함, 뺄셈으로 하면 안됨*/
        Arrays.sort(arr, (a1, a2) -> {
            if(a1[2] < a2[2]) return 1;
            return -1;
        });

        double result = 0;
        double weight = 0;
        for (int i = 0; i < N; i++) {

            if (M < weight + arr[i][0]) {
                result += ((double) M - weight) * arr[i][2];
                break;
            }

            result += arr[i][1];
            weight += arr[i][0];
        }

        System.out.printf("%.3f", result);
    }

}
