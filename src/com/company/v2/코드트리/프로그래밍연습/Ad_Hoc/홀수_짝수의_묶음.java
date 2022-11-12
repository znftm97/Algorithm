package com.company.v2.코드트리.프로그래밍연습.Ad_Hoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홀수_짝수의_묶음 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int oddCnt = 0;
        int evenCnt = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }

        /*
         *   짝수 만들때
         *   1. 짝수가 남아있으면 1개 그대로 사용
         *   2. 짝수가 없고 홀수 개수가 2개 이상이면 홀수 2개로 짝수 만듬
         *   3. 홀수가 1개만 남아있는 상황이라면 문제를 풀 수 없음, 이전에 만든 그룹 하나를 제거 (이전 짝그룹, 홀그룹, 현재남은 홀수를 하나의 그룹으로 만드는 것)
         *
         *   홀수 만들때
         *   1. 홀수가 남아있으면 1개 그대로 사용
         *   2. 이외에는 문제를 풀 수 없음
         * */
        while (true) {
            if (result % 2 == 0) { // 짝수 만들어야 할 때
                if (evenCnt > 0) {
                    evenCnt--;
                    result++;
                } else if (oddCnt >= 2) {
                    oddCnt -= 2;
                    result++;
                } else {
                    if (oddCnt > 0) {
                        result--;
                    }

                    break;
                }
            } else if (result % 2 == 1) { // 홀수 만들어야 할 때
                if (oddCnt > 0) {
                    oddCnt--;
                    result++;
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }

}
