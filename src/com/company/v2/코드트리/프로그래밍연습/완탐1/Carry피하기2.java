package com.company.v2.코드트리.프로그래밍연습.완탐1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Carry피하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = -1;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] num1 = new int[5];
        int[] num2 = new int[5];
        int[] num3 = new int[5];

        for (int i = 0; i < N; i++) {
            separateFill(num1, nums[i]);

            for (int j = i + 1; j < N; j++) {
                separateFill(num2, nums[j]);

                for (int k = j + 1; k < N; k++) {
                    separateFill(num3, nums[k]);
                    if (isNotCarry(num1, num2, num3)) {
                        result = Math.max(result, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }

        System.out.println(result);
    }

    // 숫자 n의 각 자리수를 배열에 저장
    private static void separateFill(int[] num, int n) {
        Arrays.fill(num, 0);
        int len = String.valueOf(n).length();

        for (int i = 4; i > 4 - len; i--) {
            num[i] = n % 10;
            n /= 10;
        }
    }

    // 세 숫자의 각 자리수 합이 10 이상이면 조건 불만족
    private static boolean isNotCarry(int[] num1, int[] num2, int[] num3) {
        for (int i = 0; i < 5; i++) {
            if (num1[i] + num2[i] + num3[i] >= 10) {
                return false;
            }
        }

        return true;
    }

}
