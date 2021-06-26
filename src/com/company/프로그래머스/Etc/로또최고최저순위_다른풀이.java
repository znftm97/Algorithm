package com.company.프로그래머스.Etc;

import java.io.IOException;

/*1. 두 배열의 요소 중 일치하는 숫자 개수 카운팅
 * 2. 최고순위 = 7 - 일치하는 개수 + 0 개수
 * 3. 최저순위 = 7 - 일치하는개수
 * 4. 6등인경우는 예외처리
 * */
public class 로또최고최저순위_다른풀이 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int matchCount=0;
        int zeroCount=0;
        int[] answer = new int[2];
        int[] check = new int[46];

        for (int i = 0; i < 6; i++) {
            check[lottos[i]]++;
            check[win_nums[i]]++;
        }

        /*일치하는 개수 카우팅*/
        for (int i = 1; i < 46; i++) {
            if (check[i] == 2) {
                matchCount++;
            }
        }

        /*0 개수 카운팅*/
        zeroCount = check[0];

        /*최고순위*/
        if(matchCount+zeroCount == 0){
            answer[0] = 6;
        } else {
            answer[0] = 7 - (matchCount + zeroCount);
        }

        /*최저순위*/
        if(matchCount==0){
            answer[1] = 6;
        }else {
            answer[1] = 7 - matchCount;
        }

        return answer;
    }
}
