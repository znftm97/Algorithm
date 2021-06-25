package com.company.해커랭크.easy;

import java.util.List;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        int[] check = new int[100];
        int answer = 0;

        for(int i = 0; i<a.size(); i++){
            check[a.get(i)] += 1;
        }

        for(int i = 0; i<check.length; i++){
            if(check[i]==1){
                answer = i;
            }
        }

        if(a.size() == 1){
            answer = 1;
        }

        return answer;
    }
}
