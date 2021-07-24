package com.company.백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0, end = N-1;
        int resultA = 0, resultB = 0;
        int sum = 0;
        int gap = Integer.MAX_VALUE;

        while (start < end) {
            sum = arr[start] + arr[end];

            /*합이 0이면 조건 만족하므로 이후로 진행할 필요없음*/
            if (sum == 0) {
                resultA = arr[start];
                resultB = arr[end];
                break;
            }

            /*이전에 연산한 gap보다 현재 연산한 gap이 더 작으면 수행*/
            if (Math.abs(sum) < gap) {
                gap = Math.abs(sum);
                resultA = arr[start];
                resultB = arr[end];
            }

            /*sum이 양수이면 배열에서 연산한 음수 값보다 양수값이 더 크다는 이야기이므로 end 포인트를 앞으로 당김*/
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(resultA + " " + resultB);
    }
}
