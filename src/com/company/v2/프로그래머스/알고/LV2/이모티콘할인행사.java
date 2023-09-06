package com.company.v2.프로그래머스.알고.LV2;

public class 이모티콘할인행사 {
    static int maxSubscribers;
    static int maxSalesPrice;
    static int[] discountRates = {10, 20, 30, 40};
    static int[] copyDiscountRates;

    public int[] solution(int[][] users, int[] emoticons) {
        copyDiscountRates = new int[emoticons.length];
        recursion(0, emoticons, users);

        int[] results = new int[2];
        results[0] = maxSubscribers;
        results[1] = maxSalesPrice;
        return results;
    }

    static void recursion(int depth, int[] emoticons, int[][] users) {
        if(depth == emoticons.length) {
            calculate(emoticons, users);
            return;
        }

        for(int i = 0; i < discountRates.length; i++) {
            copyDiscountRates[depth] = discountRates[i];
            recursion(depth + 1, emoticons, users);
        }
    }

    static void calculate(int[] emoticons, int[][] users) {
        int[][] discountEmoticons = new int[emoticons.length][2];
        for(int i = 0; i< emoticons.length; i++) {
            discountEmoticons[i][0] = emoticons[i] - (emoticons[i] * copyDiscountRates[i] / 100);
            discountEmoticons[i][1] = copyDiscountRates[i];
        }

        int totalSum = 0;
        int subscribers = 0;

        for (int[] user : users) {
            int sum = 0;
            for (int[] discountEmoticon : discountEmoticons) {
                if (user[0] <= discountEmoticon[1]) {
                    sum += discountEmoticon[0];
                }
            }

            if (sum >= user[1]) subscribers++;
            else totalSum += sum;
        }

        if(maxSubscribers < subscribers) {
            maxSubscribers = subscribers;
            maxSalesPrice = totalSum;
        } else if (maxSubscribers == subscribers) {
            maxSalesPrice = Math.max(maxSalesPrice, totalSum);
        }

    }
}
