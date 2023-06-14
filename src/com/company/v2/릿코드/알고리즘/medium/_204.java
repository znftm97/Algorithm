package com.company.v2.릿코드.알고리즘.medium;

public class _204 {
    private boolean[] nonePrimes;

    public int countPrimes(int n) {
        if(n==0 || n==1) return 0;

        nonePrimes = new boolean[n + 1];
        nonePrimes[0] = nonePrimes[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if(nonePrimes[i]) continue;
            for (int j = i * i; j < nonePrimes.length; j += i) {
                nonePrimes[j] = true;
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if(!nonePrimes[i]) cnt++;
        }

        return cnt;
    }
}
