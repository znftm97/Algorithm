package com.company.프로그래머스.Etc;

import java.util.stream.IntStream;

/* zeroCount = 2, matchCount = 2 / 최대 zeroCount + matchCount = 4 --> 3위 / 최소 matchCount = 2 --> 5위
   zeroCount = 6, matchCount = 0 / 최대 zeroCount + matchCount = 6 --> 1위 / 최소 matchCount = 0 --> 6위
   zeroCount = 0, matchCount = 6 / 최대 zeroCount + matchCount = 6 --> 1위 / 최소 matchCount = 6 --> 1위 */
public class 로또최고최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int matchCount = 0;
        int min, max = 0;

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            /*win_nums 배열에 lottos 배열의 요소가 있으면 true값을 리턴하고 matchCount++
             * 이 방법은 시간을 많이 잡아먹기때문에 로또 숫자 46개만큼의 boolean 배열을 선언해서 개수 세는게 더 나음
             * */
            if (IntStream.of(win_nums).anyMatch(x -> x == lottos[finalI])) {
                matchCount++;
            }
            if (lottos[i] == 0) {
                zeroCount++;
            }
        }

        min = matchCount;
        max = matchCount + zeroCount;
        answer[0] = Math.min(7 - max, 6); // 최고순위
        answer[1] = Math.min(7 - min, 6); // 최저순위

        return answer;
    }
}
