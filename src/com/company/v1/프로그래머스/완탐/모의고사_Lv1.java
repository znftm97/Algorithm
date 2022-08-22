package com.company.v1.프로그래머스.완탐;

import java.util.ArrayList;

public class 모의고사_Lv1 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        int answer1=0, answer2 =0, answer3 =0;

        /*맞은 문제수 체크*/
        for(int i =0; i<answers.length; i++){
            if(arr1[i%5] == answers[i]) answer1++; // 각 문제수가 정해져 있으므로 조건문에서 그냥 숫자 넣고, 이게 가변적이라면 length로
            if(arr2[i%8] == answers[i]) answer2++;
            if(arr3[i%10] == answers[i]) answer3++;
        }

        int max = Math.max(Math.max(answer1, answer2),answer3); //최대값 구하기

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==answer1) list.add(1); //max값이랑 같으면 list에 추가
        if(max==answer2) list.add(2);
        if(max==answer3) list.add(3);

        answer = new int[list.size()];

        for(int i =0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
