package com.company.프로그래머스.LV2;

public class 예상대진표 {
    public int solution(int N, int A, int B){
        int result = 1;

        while (true) {
            if (Math.abs(A - B) == 1) {
                if (A < B) {
                    if (A % 2 == 1 && B % 2 == 0) return result; // A < B일 때 A가 홀수, B가 짝수인 경우면 만난다.
                } else {
                    if (A % 2 == 0 && B % 2 == 1) return result; // A > B일 때 A가 짝수, B가 홀수인 경우면 만난다.
                }
            }

            A = nextRoundNumSetting(A);
            B = nextRoundNumSetting(B);

            result++;
        }
    }

    /*짝수면 2로나누고, 홀수면 2로나눈후 1더해주면 다음라운드의 번호가 된다.*/
    private static int nextRoundNumSetting(int num) {
        return num % 2 == 0 ? num /= 2 : num / 2 + 1;
    }

}
