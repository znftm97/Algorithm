package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶기_1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> positiveNums = new ArrayList<>();
        List<Integer> negativeNums = new ArrayList<>();
        boolean existZero = false; // 음수가 홀수이고 0이 존재하면 남은 1개의 음수는 0으로 삭제 가능
        int result = 0;

        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) existZero = true;
            else if(num > 0) positiveNums.add(num);
            else negativeNums.add(num);
        }

        int pLen = positiveNums.size();
        int nLen = negativeNums.size();

        positiveNums.sort(Collections.reverseOrder());
        Collections.sort(negativeNums);

        if (!positiveNums.isEmpty()) {
            if (positiveNums.size() % 2 == 0) { // 양수 개수가 짝수인 경우
                for (int i = 0; i < pLen - 1; i+=2) {
                    long num1 = positiveNums.get(i);
                    long num2 = positiveNums.get(i + 1);

                    if (num1 == 1 || num2 == 1) { // 곱셈에 1이 포함되어 있으면, 곱보다 더하는게 더 큼
                        result += num1 + num2;
                    } else {
                        result += num1 * num2;
                    }
                }
            } else { // 양수 개수가 홀수인 경우 (남은 1개 수 처리 필요)
                for (int i = 0; i < pLen - 2; i+=2) {
                    long num1 = positiveNums.get(i);
                    long num2 = positiveNums.get(i + 1);

                    if (num1 == 1 || num2 == 1) { // 곱셈에 1이 포함되어 있으면, 곱보다 더하는게 더 큼
                        result += num1 + num2;
                    } else {
                        result += num1 * num2;
                    }
                }

                result += positiveNums.get(pLen - 1); // 남은 1개 수 더해줌
            }
        }

        if (!negativeNums.isEmpty()) {
            if (negativeNums.size() % 2 == 0) { // 음수 개수가 짝수인경우
                for (int i = 0; i < nLen - 1; i+=2) {
                    long num1 = negativeNums.get(i);
                    long num2 = negativeNums.get(i + 1);

                    result += num1 * num2;
                }
            } else { // 음수 개수가 홀수인 경우 (남은 1개 수 처리 필요)
                for (int i = 0; i < nLen - 2; i+=2) {
                    long num1 = negativeNums.get(i);
                    long num2 = negativeNums.get(i + 1);

                    result += num1 * num2;
                }

                if (!existZero) { // 남은 1개의 음수는, 0이 존재하지 않으면 결과에 더해줌, 0이 존재하면 곱해서 0이되므로 따로 처리 필요 x
                    result += negativeNums.get(nLen - 1);
                }
            }
        }

        System.out.println(result);
    }

}
