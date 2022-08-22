package com.company.v1.프로그래머스.문자열;

import java.io.IOException;

public class 가장긴팰린드롬 {
    public static void main(String[] args) throws IOException {
        String s = "abcdecd";

        /*1. 문자열을 char 배열로*/
        char[] arr = s.toCharArray();

        /*2. 총 3번의 반복문을 진행0
         * 먼저 가장 긴 문자열부터 이 문자열이 회문을 만족하는지 안하는지 검사 후 만족하면 길이 저장 후 반복문탈출
         * 만족 안하면 배열 인덱스 값 하나 줄여서 해당 길이의 모든 문자열 검사 (abdcecd -> abdcec -> bdcecd -> abdce -> bdcec -> dcecd ...)
         * */
        for(int len = s.length(); len>1; len--){
            for(int start = 0; start+len<=s.length(); start++){
                boolean check = true;

                for(int i =0; i<len/2; i++){ // 10개의 문자열을 2개씩 비교하니까 5번만 해도됨 -> len/2
                    //시작점 : start부터 i씩 증가 , 끝점 : start+문자열길이만큼(len)-1(인덱스니까) 부터 i씩 감소
                    if(arr[start + i] != arr[start+len-i-1]){ // 앞에서부터 문자와 뒤에서부터 문자 비교해서 다르면 check=false
                        check = false;
                        break;
                    }
                }

                if(check){ // 위 조건에서 안걸렸으면 회문 만족 리턴
                    System.out.println(len);
                    return;
                }
            }
        }

        /*위에서 계속 조건에 걸려서 만족을 못했다면 한 글자인 경우*/
        System.out.println(1);
    }
}
