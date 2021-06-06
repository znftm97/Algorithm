package com.company.프로그래머스.Etc;

public class 자연수뒤집어배열만들기 {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        String reverseStr = new StringBuffer(s).reverse().toString();
        String[] arr = reverseStr.split("");
        int[] answer = new int[arr.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }

        return answer;
    }
}
