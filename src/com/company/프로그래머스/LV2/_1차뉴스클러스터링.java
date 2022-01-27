package com.company.프로그래머스.LV2;

import java.util.ArrayList;
import java.util.List;

public class _1차뉴스클러스터링 {
    private static List<Character> alphabets = new ArrayList<>();

    public int solution(String str1, String str2) {
        for (int i = 0; i < 26; i++) {
            alphabets.add((char)('a' + i));
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> A = convert(str1);
        List<String> B = convert(str2);

        double intersectionCnt = 0;
        double unionCnt = 0;

        for (String s : A) {
            if(B.contains(s)) {
                B.remove(s);
                intersectionCnt++;
            }
        }
        unionCnt = A.size() + B.size(); // 교집합을 제외한 나머지

        if(intersectionCnt == 0 && unionCnt == 0) return 65536;
        else if (intersectionCnt == 0) return 0; // 0을 나눌수없다.

        return (int) Math.floor((intersectionCnt / unionCnt) * 65536);
    }

    private static List<String> convert(String s){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (!alphabets.contains(c1) || !alphabets.contains(c2)) continue;

            list.add(sb.append(c1).append(c2).toString());
            sb.setLength(0);
        }

        return list;
    }

}
