package com.company.v1.프로그래머스.Etc;

public class 최소직사각형_LV1 {
    public int solution(int[][] sizes) {
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
        }

        int rMax = Integer.MIN_VALUE;
        int cMax = Integer.MIN_VALUE;
        for(int i = 0; i<sizes.length; i++){
            rMax = Math.max(rMax, sizes[i][0]);
            cMax = Math.max(cMax, sizes[i][1]);
        }

        return rMax * cMax;
    }
}
