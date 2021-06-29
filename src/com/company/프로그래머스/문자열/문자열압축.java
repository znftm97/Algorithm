package com.company.프로그래머스.문자열;

import java.io.IOException;

public class 문자열압축 {
    public static void main(String[] args) throws IOException {
        String s = "abcabcdede";
        int min = s.length();

        /*문자열을 1글자씩, 2글자씩 , 3글자씩.... 짤라서 압축된 결과중 최소값을 구함
        * 문자열길이의 절반이 넘어가면 어차피 압축 안되는 경우이기 때문에 /2 */
        for (int i = 1; i < s.length() / 2; i++) {
            int compLeng = compression(s, i).length();
            min = Math.min(min, compLeng);
        }

        System.out.println(min);
    }

    static String compression(String str, int i) {
        String pattern = ""; // 이전 문자열
        String compression =""; // 압축된 문자열 저장
        int count = 1; // 중복 카운트

        /*문자열을 반복탐색하는데 i만큼 증가할거임, 예로 3글자씩 자를때는 일일이 한글자씩 탐색할 필요 없으니까*/
        for (int j = 0; j<=str.length() + i; j+=i){
            String nowStr;

            /*1. 이전 문자열과 비교할 현재 문자열 생성*/
            if (j >= str.length()) { // 현재 문자열이 없을 때
                nowStr = "";
            } else if (str.length() < j + i) {
                nowStr = str.substring(j);
            } else{
                nowStr = str.substring(j, j + i);
            }

            /*2. 현재 문자열과 이전 문자열 비교*/
            if (j != 0) { // 맨처음은 비교 안함
                if(nowStr.equals(pattern)){ // 같으면 카운팅
                    count++;
                } else if (count >= 2) { // 다른데 중복이 카운팅 됬으면
                    compression += count + pattern;
                    count = 1;
                } else { // 다른데 중복도 없으면 그냥 추가
                    compression += pattern;
                }
            }

            pattern = nowStr;
        }

        return compression;
    }
}
