package com.company.프로그래머스.누적합;

import java.io.IOException;

/*백준은 값을 다 입력받지만 프로그래머스는 배열로 주어질테니 풀이 방법이 바뀌므로 임의로 문제를 만들고 풀이*/
public class 커스텀 {
    public static void main(String[] args) throws IOException {
        // 문제에서 아래 배열이 주어 졌다고 가정
        int[] array1 = {5, 4, 3, 2, 1};
        int[][] array2 = {{1,3}, {2,4}, {5,5}};

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[array1.length + 1]; // 이전 요소 탐색해서 더하므로 +1

        /*누적합 계산*/
        for (int i = 1; i <= array1.length; i++) {
            arr[i] = arr[i-1] + array1[i-1];
        }

        /*결과값 구하기 공식은 누적합 배열에서 y-(x-1)*/
        for (int i = 0; i < array2.length; i++) {
            sb.append(arr[array2[i][1]] - arr[array2[i][0]-1]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
