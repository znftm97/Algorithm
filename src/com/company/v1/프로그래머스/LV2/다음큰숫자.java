package com.company.v1.프로그래머스.LV2;

public class 다음큰숫자 {
    public int solution(int n){
        int bitCnt = Integer.bitCount(n);

        while (true) {
            if(Integer.bitCount(++n) == bitCnt) return n;
        }
    }

}
