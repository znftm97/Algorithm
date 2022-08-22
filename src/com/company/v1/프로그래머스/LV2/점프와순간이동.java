package com.company.v1.프로그래머스.LV2;

public class 점프와순간이동 {
    public int solution(int n) {
        int result = 0;

        if(n==1) return 1;

        /*짝수면 무조건 순간이동 가능함, 홀수나 소수인경우에는 짝수칸에서 1칸 점프하면됨
         * 즉 n을 2로 계속나눠서 짝수가 아닌경우를 카운팅하면됨, 2까지 이동하는 건전지 사용량 마지막에 +1*/
        while (true) {
            if(n==2) break;

            if(n%2 == 0)n /= 2;
            else {
                result++;
                n -= 1;
            }
        }

        return result + 1;
    }

}
