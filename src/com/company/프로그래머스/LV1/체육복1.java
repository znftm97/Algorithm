package com.company.프로그래머스.LV1;

import java.io.IOException;

public class 체육복1 {
    public static void main(String[] args) throws IOException {
        int[] lost = {2,3,4};
        int[] reserve = {1,5};

        System.out.println(solution(5, lost, reserve));
    }

    /*도난당한 학생은 = 0, 체육복이 있는 학생 = 1, 여별의 체육복까지 있는학생 = 2*/
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];

        /*모든 학생을 1로 세팅*/
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        /*여벌의 체육복이 있는 학생 2로 세팅, 체육복이 있는 학생도 도난당할 수 있기 때문에 먼저 수행되어야 한다.*/
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]-1] = 2;
        }

        /*도난당한 학생 0으로 세팅*/
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]-1] = 0;
        }

        /*배열을 앞뒤로 조회하기 때문에 맨첫요소나 끝요소 탐색 시인덱스아웃 에러 날거임
        * 따라서 맨 처음인경우와 맨 끝인경우 분기처리
        * */
        for (int i = 1; i < n-1; i++) {
            /*맨 첫 요소가 2이고 다음요소가 0인경우 체육복 빌려줌*/
            if (i == 1 && arr[0] == 2 && arr[1] == 0) {
                arr[1] = 1;
            }

            /*맨 끝 요소가 2이고, 이전요소가 0인경우 체육복 빌려줌*/
            if (i == n-2 && arr[n-2] == 0 && arr[n-1] == 2) {
                arr[n-2] = 1;
            }

            /*요소가 2인경우*/
            if (arr[i] == 2) {
                /*앞에 요소부터 탐색 0인경우 체육복 빌려주고 1로세팅*/
                if(arr[i-1] == 0){
                    arr[i-1] = 1;
                    arr[i] = 1;
                }
                /*앞의 요소에 체육복을 이미 빌려줬을수도 있으니 현재요소가 2인경우 && 뒤에요소가 0인경우*/
                if (arr[i + 1] == 0 && arr[i] == 2) {
                    arr[i+1] = 1;
                    arr[i] = 1;
                }
            }
        }

        int count = 0;
        for (int i : arr) {
            if(i >= 1) count++;
        }

        return count;
    }
}
