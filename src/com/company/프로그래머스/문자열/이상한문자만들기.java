package com.company.프로그래머스.문자열;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        String arr[] = s.split("");
        String space = " ";
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(space)){
                count = 0;
            }else{
                if(count % 2 == 0){
                    count++;
                    arr[i] = arr[i].toUpperCase();
                }else{
                    count++;
                    arr[i] = arr[i].toLowerCase();
                }
            }
            answer += arr[i];
        }

        return answer;
    }
}
