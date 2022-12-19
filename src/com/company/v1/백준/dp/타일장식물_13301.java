package com.company.v1.백준.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 9625번과 같은 유형의 문제, 단 인덱스가 즉 타일의 개수가 짝수 홀수인지에 따라 살짝다름
가로,세로 두번씩 더하니 *2로 처리하고 각 가로, 세로 길이를 나타내면 아래와 같음
타일의 개수가 짝수인 경우엔 가로 길이는 이전과 같고, 세로 길이는 이전의 가로+세로값
(1+1) * 2
(1+2) * 2
(3+2) * 2
(3+2) * 2
(8+2) * 2
* */
public class 타일장식물_13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dpWidth = new long[N + 1];
        long[] dpHeight = new long[N + 1];
        dpWidth[1] = 1;
        dpHeight[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                dpWidth[i] = dpWidth[i - 1];
                dpHeight[i] = dpWidth[i - 1] + dpHeight[i - 1];
            } else {
                dpWidth[i] = dpWidth[i - 1] + dpHeight[i - 1];
                dpHeight[i] = dpHeight[i - 1];
            }
        }

        System.out.println((dpWidth[N] + dpHeight[N]) * 2);
        br.close();
    }

}
