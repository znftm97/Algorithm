package com.company.v2.릿코드.알고리즘.medium;

import java.math.BigInteger;

public class _365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity) return false;
        if(jug1Capacity + jug2Capacity == targetCapacity) return true;

        int gcd = getGCD(jug1Capacity, jug2Capacity);
        if(targetCapacity % gcd == 0) return true;

        return false;
    }

    int getGCD(int cup1, int cup2) {
        return BigInteger.valueOf(cup1).gcd(BigInteger.valueOf(cup2)).intValue();
    }
}
