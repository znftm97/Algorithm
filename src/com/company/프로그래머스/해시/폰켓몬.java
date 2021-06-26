package com.company.프로그래머스.해시;

import java.util.HashSet;

/*문제의 핵심은 최대한 다른 포켓몬의 종류를 구하는 것 == 숫자의 중복을 제거하여 서로 다른 숫자의 개수를 구하면 됨
* 단, 내가 가져갈 포켓몬의 수는 배열길이의 반으로 정해져 있음 이에 따른 경우의 수만 나눠주면 됨
* */
public class 폰켓몬 {
    public int solution(int[] nums) {
        HashSet<Integer> removeOverlapCount = new HashSet<>();
        int getPocketmonCount = nums.length/2; // 내가 가져갈 포켓몬 수

        /*중복 제거*/
        for (int i : nums) {
            removeOverlapCount.add(i);
        }

        /*경우의 수
        * 포켓몬 종류 >= 내가 가져갈 포켓몬 수 --> 가져갈 포켓몬 수 리턴
        * 포켄몬 종류 < 내가 가져갈 포켓몬 수 --> 포켓몬 종류 수 리턴
        * */
        if (removeOverlapCount.size() >= getPocketmonCount) {
            return getPocketmonCount;
        } else {
            return removeOverlapCount.size();
        }
    }
}
