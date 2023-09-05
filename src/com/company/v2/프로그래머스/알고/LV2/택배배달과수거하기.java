package com.company.v2.프로그래머스.알고.LV2;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dCap = 0;
        int pCap = 0;
        long result = 0;

        for (int i = n-1; i >= 0; i--) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                continue;
            }

            int cnt = 0;
            while(dCap < deliveries[i] || pCap < pickups[i]) {
                cnt++;
                dCap += cap;
                pCap += cap;
            }

            dCap -= deliveries[i];
            pCap -= pickups[i];
            result += (long) (i + 1) * cnt * 2;
        }

        return result;
    }
}
