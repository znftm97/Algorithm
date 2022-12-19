package com.company.v1.프로그래머스.Etc;

/*에라토스테네스의 체 이용*/
public class 소수찾기 {
    public int solution(int n) {
        int count = 0;
        boolean[] check = new boolean[n+1];

        for (int i= 2; i < Math.sqrt(n); i++) {
            /*이미 true인 요소일 때는 다음 요소로*/
            if (check[i] == true) {
                continue;
            }

            /*i의 배수들도 true로 변경*/
            for (int j = i * i; j < check.length; j = j + i) {
                check[j] = true;
            }
        }

        /*소수 개수 세기*/
        for (int i = 2; i <= n; i++) {
            if (check[i] == false) {
                count++;
            }
        }

        return count;
    }
}
