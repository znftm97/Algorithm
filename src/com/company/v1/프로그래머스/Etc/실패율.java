package com.company.v1.프로그래머스.Etc;

import java.util.ArrayList;
import java.util.Collections;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] stageUser = new double[N+1]; // 각 스테이지별 사용자 수

        /*각 스테이지별 사용자 수 구하기*/
        for(int i : stages){
            if(i == N+1){
                continue;
            }
            stageUser[i]++;
        }

        ArrayList<Double> stageFailPer = new ArrayList<Double>(); // 실패율
        double num = stages.length; //스테이지에 도달한 명수
        double tmp = 0; //다음 스테이지로 올라갈때 줄어드는 사용자수를 계산하기 위해 사용

        //실패율을 구한 후 다시 stage배열에 담고, stageFailPer 리스트에도 담아준다.
        for(int i=1; i<stageUser.length; i++){
            tmp = stageUser[i];
            if(num == 0){ // 도달한 사용자 수가 0 일때, 실패율도 0
                stageUser[i]=0;
            }else{
                stageUser[i] = stageUser[i]/num;
                num = num - tmp;
            }
            stageFailPer.add(stageUser[i]);
        }

        Collections.sort(stageFailPer,Collections.reverseOrder());
        //정렬된 fail리스트 값과 stage값을 비교해서 같으면 stage의 인덱스번호(스테이지번호)를 가져옴으로써
        //실패율이 높은 순으로 answer배열에 넣어준다.
        for(int i=0; i<stageFailPer.size(); i++){
            for(int j=1; j<stageUser.length; j++){
                if(stageFailPer.get(i) == stageUser[j]){
                    answer[i] = j;
                    stageUser[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
