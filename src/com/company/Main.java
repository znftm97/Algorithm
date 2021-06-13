package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern IDENTIFY = Pattern.compile("[A-Z][A-Z]");

    public static void main(String[] args) throws IOException {
        String str1 = "FRANCE";
        String str2 = "french";

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        double intersectionCount = 0; // 교집합 개수
        double unionCount = 0; // 합집합 개수
        int answer = 0;

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        /*두 글자씩 추출*/
        list1 = extract(str1);
        list2 = extract(str2);


        for(String s : list1){
            if(list2.remove(s)){
                intersectionCount++;
            }
            unionCount++;
        }

        for(String s : list2){
            unionCount++;
        }

        System.out.println(intersectionCount / unionCount);
        answer = (int) Math.floor((intersectionCount / unionCount) * 65536); // int형으로 캐스팅해서 소수값 버리기
        if (answer == 0) { // 일치하는 요소가 없는 경우
            System.out.println("65536");
        }

        System.out.println(answer);
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

