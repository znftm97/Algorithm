package com.company.v1.프로그래머스.문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class 뉴스클러스터링 {
    private static final Pattern IDENTIFY = Pattern.compile("[A-Z][A-Z]");

    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>(); // str1 문자열을 두개씩 추출해서 담을 list1
        List<String> list2 = new ArrayList<>(); // str1 문자열을 두개씩 추출해서 담을 list2
        double intersectionCount = 0; // 교집합 개수
        double unionCount = 0; // 합집합 개수
        int answer = 0;

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        /*두 글자씩 추출*/
        list1 = extract(str1);
        list2 = extract(str2);

        /*교집합, 합집합 개수 구하기*/
        for(String s : list1){
            if(list2.remove(s)){
                intersectionCount++;
            }
            unionCount++;
        }
        for(String s : list2){
            unionCount++;
        }

        if (intersectionCount == 0 && unionCount == 0) { // 집합 A,B가 공집합인 경우(교집합, 합집합의 개수가 0)
            return 65536;
        }
        if (intersectionCount == 0) { // 교집합만 공집합인 경우(교집합의 개수가 0)
            return 0;
        }

        return (int) Math.floor((intersectionCount / unionCount) * 65536); // floor로 소수점 버리고 int형으로 변환
    }

    static List<String> extract(String s) {
        List<String> list = new ArrayList<>();
        int before = 0;
        int after = 1;

        while (true) {
            if (after == s.length()) { // 문자열 끝까지 다 탐색했을 때
                return list;
            }

            String createStr = String.valueOf(s.charAt(before)) + String.valueOf(s.charAt(after));
            if(IDENTIFY.matcher(createStr).matches()){
                list.add(createStr);
            }

            before++;
            after++;
        }
    }
}
