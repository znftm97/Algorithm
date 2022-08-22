package com.company.v1.프로그래머스.LV2;

import java.util.Arrays;

public class 전화번호목록_정렬 {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if(phoneBook[i+1].startsWith(phoneBook[i])) return false;
        }

        return true;
    }
}
