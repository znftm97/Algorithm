package com.company.프로그래머스.문자열;

import java.io.IOException;

public class 가장긴팰린드롬_다른풀이 {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        String input = "aabaabda";
        arr = input.toCharArray();

        for (int i = 0; i < arr.length; i++) { // 입력받은 문자열의 길이만큼 반복
            int len = arr.length;
            len -= i; // 길이를 1씩감소 ( 8-0 = 8 -> 8-1 = 7 -> 8-2 = 6 ...)
            int startIndex = 0;
            int endIndex = startIndex + len - 1; // 배열 인덱스 값이기 때문에 -1

            while (true) { // len 길이만큼의 문자열이 팰린드롬을 만족하는지( 만약 len이 6이라면 aabaab -> abaabd -> baabda 세 번 탐색)
                if (endIndex >= arr.length) break; // endIndex가 배열 범위 벗어나면 탈출

                if (isPalindrome(len, startIndex, endIndex)) {
                    System.out.println(len);
                    return;
                }

                startIndex++;
                endIndex++;
            }
        }
    }

    public static boolean isPalindrome(int len, int startIndex, int endIndex) {
        boolean check = true;

        for (int j = 0; j < len / 2; j++) {// 길이절반만 탐색
            if (arr[startIndex++] != arr[endIndex--]) {
                check = false;
                break;
            }
        }

        return check;
    }
}
