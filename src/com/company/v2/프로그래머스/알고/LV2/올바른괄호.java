package com.company.v2.프로그래머스.알고.LV2;

import java.util.Stack;

public class 올바른괄호 {
    public boolean solution(String msg){
        int unpairCnt = 0;

        for (char c : msg.toCharArray()) {
            if (c == '(') {
                unpairCnt++;
            } else {
                unpairCnt--;
            }

            if (unpairCnt < 0) {
                return false;
            }
        }

        if (unpairCnt == 0) {
            return true;
        }

        return false;
    }

}
