package com.company.프로그래머스.LV1;

public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (decimalCheck(num)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    /*소수 판별 알고리즘
    * 원래는 num이 0,1일때 소수가 아닌 상황과 num 2일때 소수인 상황 if문 처리해야함
    * 문제에서 숫자는 1이상이고 중복되는 숫자가 없다고 했으니 최소값은 1+2+3 = 6 이므로 num이 0,1,2 일때 if문은 처리 안해도 됨
    * */
    public boolean decimalCheck(int num) {

        /*sqrt 메서드는 제곱근을 리턴해준다.*/
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {  // 소수가 아닌 경우
                return false;
            }
        }

        return true; // 반복문을 다 돌면 나눠지는 수가 없는거니까 소수라서 true 반환
    }
}
