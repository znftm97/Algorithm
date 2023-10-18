package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        Map<String, Integer> A = split(str1.toLowerCase());
        Map<String, Integer> B = split(str2.toLowerCase());

        int a = getIntersectionCnt(A,B);
        int b = getUnionCnt(A,B);

        return (a == 0 && b == 0) ? 65536 : (int) ((double) a/b * 65536);
    }

    static Map<String, Integer> split(String s) {
        int start = 0;
        int end = 1;
        Map<String, Integer> strToCntMap = new HashMap<>();

        while(end < s.length()) {
            String sub = s.substring(start, end + 1);
            if(isOnlyAlphabet(sub)) {
                strToCntMap.put(sub, strToCntMap.getOrDefault(sub, 0) + 1);
            }
            start++;
            end++;
        }

        return strToCntMap;
    }

    static boolean isOnlyAlphabet(String s) {
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!('a' <= c && c <= 'z')) {
                return false;
            }
        }

        return true;
    }

    static int getIntersectionCnt(Map<String, Integer> A, Map<String, Integer> B) {
        int cnt = 0;
        for(String key : A.keySet()) {
            if(B.containsKey(key)) {
                cnt += Math.min(A.get(key), B.get(key));
            }
        }

        return cnt;
    }

    static int getUnionCnt(Map<String, Integer> A, Map<String, Integer> B) {
        Set<String> checkSet = new HashSet<>();
        int cnt = 0;

        for(String key : A.keySet()) {
            if(B.containsKey(key)) {
                cnt += Math.max(A.get(key), B.get(key));
            } else {
                cnt += A.get(key);
            }

            checkSet.add(key);
        }

        for(String key : B.keySet()) {
            if(!checkSet.contains(key)) {
                cnt += B.get(key);
            }
        }

        return cnt;
    }
}
