package com.company.v2.프로그래머스.알고.LV2;

public class 예상대진표 {
    public int solution(int N, int A, int B){
        int round = 1;

        while (true) {
            int min = Math.min(A, B);
            int max = Math.max(A, B);
            if (min % 2 == 1 && max % 2 == 0 && max - min == 1) {
                break;
            }

            if (A % 2 == 0) {
                A /= 2;
            } else {
                A = A / 2 + 1;
            }

            if (B % 2 == 0) {
                B /= 2;
            } else {
                B = B / 2 + 1;
            }

            round++;
        }

        return round;
    }

}
