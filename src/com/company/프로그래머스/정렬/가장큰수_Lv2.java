package com.company.프로그래머스.정렬;

import java.util.Arrays;

public class 가장큰수_Lv2 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        /*"10", "6"인 경우 610.compareTo(106) 을 비교해서 610이 더크니까 양수를 반환하고 10과 6의 자리를 바꿔줌*/
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        /*배열의 원소 3개가 주어졌는데 모두 0일경우 답은 0이되어야 하지만 문자열이라 000이 되어버리기 때문에 검사*/
        if (arr[0].equals("0")) {
            return "0";
        }

        for (String s : arr) {
            answer += s;
        }
        return answer;
    }
}

