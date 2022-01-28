package com.company.프로그래머스.LV2;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록_해시 {
    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook[i].length(); j++) {
                if (map.containsKey(phoneBook[i].substring(0, j))) return false;
            }
        }

        return true;
    }

}
