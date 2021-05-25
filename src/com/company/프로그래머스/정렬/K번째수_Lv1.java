package com.company.프로그래머스.정렬;

import java.util.Arrays;

/*  1. 배열을 잘라서 새로운 배열에 복사
        - copyOf() 배열 전체복사
        - copyOfRange() 배열 일부 복사, 세 번째 파라미터로 지정된 수는 포함되지 않음
        - 그래서 3번째 파라미터는 1을 빼주지 않음, 내부ㅡ
    2. 새로운 배열 정렬
    3. 정렬 후 k 인덱스에 해당하는 값을 반환배열에 추가
*
* */
public class K번째수_Lv1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}
