package com.company.프로그래머스.스택큐;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;

            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                }

                if (prices[i] > prices[j]){
                    count++;
                    break;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
