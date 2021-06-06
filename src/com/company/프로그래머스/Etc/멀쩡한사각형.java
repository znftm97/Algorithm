package com.company.프로그래머스.Etc;

import java.math.BigInteger;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
}

