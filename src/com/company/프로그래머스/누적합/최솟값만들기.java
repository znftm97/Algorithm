package com.company.프로그래머스.누적합;

import java.util.*;

/*최솟값은 가장 큰수와 가장 작은수를 곱해주면 되므로 둘 다 오름차순 정렬 후
* A는 앞에부터 B는 뒤에서부터 계산해주면 된다.
* */
public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i] * B[B.length-1-i];
        }

        return sum;
    }
}
