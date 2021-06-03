package com.company.프로그래머스.문자열;

public class _124나라의숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int k = 0;

        while (n > 0) {
            k = n % 3; //나머지
            n = n / 3; //몫
            if (k == 0) {
                n = n-1; //자리올림을 안 하는 효과
                k = 4;
            }
            sb.append(k);
        }

        return sb.reverse().toString(); // 뒤집어서 출력해줘야함함
   }
}
