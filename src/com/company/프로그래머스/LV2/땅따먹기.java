package com.company.프로그래머스.LV2;

public class 땅따먹기 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        String indexes = "0123";

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(indexes);
                String needIndexes = sb.deleteCharAt(j).toString();

                int i1 = Integer.parseInt(String.valueOf(needIndexes.charAt(0)));
                int i2 = Integer.parseInt(String.valueOf(needIndexes.charAt(1)));
                int i3 = Integer.parseInt(String.valueOf(needIndexes.charAt(2)));

                dp[i][j] = Math.max(dp[i-1][i1], Math.max(dp[i-1][i2], dp[i-1][i3])) + land[i][j];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if(result < dp[dp.length-1][i]) result = dp[dp.length-1][i]; // Math.max 쓰면 시간초과
        }

        return result;
    }

}
