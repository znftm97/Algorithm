package com.company.v2.프로그래머스.알고.LV2;

public class 이진변환반복 {
    public int[] solution(String s) {
        int time = 0;
        int removeZeroCnt = 0;
        while(true) {
            if(s.equals("1")) break;

            int oneCnt = 0;
            for(int i = 0; i<s.length(); i++) {
                if(s.charAt(i) == '1') oneCnt++;
            }
            int zeroCnt = s.length() - oneCnt;

            removeZeroCnt += zeroCnt;
            s = Integer.toString(oneCnt, 2);
            time++;
        }

        return new int[]{time, removeZeroCnt};
    }
}
