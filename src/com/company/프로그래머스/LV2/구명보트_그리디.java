package com.company.프로그래머스.LV2;

import java.util.Arrays;

/*오름차순으로 정렬 후 최소몸무게 + 최대 몸무게가 limit보다 작으면 둘다 탈출시키고 min++ max--
* 크다면 최대몸무게 한명만 탈출시킨후 max--
* 탈출조건은 max,min이 같은 인덱스값을 가질 떄 한명만 남은 경우이므로 남은 한명 탈출시키고 무한루프 탈출
* min이 max보다 커지면 서로 위치가 바뀐거니 남은사람없음 무한루프 탈출
* */
public class 구명보트_그리디 {
    public int solution(int[] people, int limit) {
        int max = people.length - 1;
        int min = 0;
        int count = 0;
        Arrays.sort(people); // 오름차순 정렬

        while (true) {
            if (max < min){ // 서로 위치가 바뀐경우 즉 모든사람이 탈출
                break;
            } else if (max == min) { // 서로 같은 인덱스를 바라보는 경우 한명만 남은 경우, 남은 한명 탈출
                count++;
                break;
            }

            if (people[min] + people[max] > limit) { // 두 명의 몸무게가 limit보다 크면 최대값 몸무게 사람 한명만 탈출
                max--;
                count++;
            } else{ // 두명 탈출
                min++;
                max--;
                count++;
            }
        }

        return count;
    }
}
