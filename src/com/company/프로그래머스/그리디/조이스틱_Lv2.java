package com.company.프로그래머스.그리디;

public class 조이스틱_Lv2 {
    public int solution(String name) {
        int len = name.length();
        int minMoveLeftRight = len - 1;
        int minMoveUpDown = 0;

        for (int i = 0; i < len; i++) {
            /*min 메서드 두 번째파라미터에 1을 더해준 이유는, A에서 시작하기 때문에 Z로 이동하느라 조이스틱을 1번 움직여야하기 때문*/
            minMoveUpDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i+1; //다음 문자 인덱스 값

            /*마지막 문자가 아니라면 && 다음 문자가 A라면 조이스틱을 움직일 필요가 없기 때문에 다음문자로 이동*/
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }


            minMoveLeftRight = Math.min(minMoveLeftRight, i + len - next + i);
        }

        minMoveUpDown += minMoveLeftRight;

        return minMoveUpDown;
    }
}
