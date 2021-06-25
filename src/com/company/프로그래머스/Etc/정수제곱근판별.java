package com.company.프로그래머스.Etc;

public class 정수제곱근판별 {
    public long solution(long n) {
        double tmp = 1;

        if(n==1){
            return 4;
        }

        while(tmp<=Math.sqrt(n)){
            if(Math.pow(tmp,2) == n){
                return (long) Math.pow(tmp+1, 2);
            }
            tmp++;
        }

        return -1;
    }
}
