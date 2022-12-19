package com.company.v1.프로그래머스.그리디;

public class 큰수만들기_Lv2 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0; // 인덱스
        int comp = 0; // 값 비교를위한 임시변수

        for (int i = 0; i < number.length() - k; i++) {
            comp = 0; // 한 자리수 찾으면 다시 0으로 초기화 해줘야함

            /*j값을 idx로 하는 이유는 어차피 한 자리수가 선택되면 왼쪽값은 볼 필요 없음음*/
           for (int j = idx; j <= i + k; j++) {
                if (comp < number.charAt(j) - '0') {
                    comp = number.charAt(j) - '0';
                    idx = j+1;
                }
            }
            sb.append(comp);
        }

        return sb.toString();
    }
}
