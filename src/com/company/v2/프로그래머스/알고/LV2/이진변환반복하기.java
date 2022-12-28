package com.company.v2.프로그래머스.알고.LV2;

public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] result = new int[2];
        int removedZeroCnt = 0;
        int convertCnt = 0;

        while (true) {
            if (s.equals("1")) {
                break;
            }

            String removedZeroStr = s.replaceAll("0", "");
            removedZeroCnt += s.length() - removedZeroStr.length();

            int num = removedZeroStr.length();
            s = Integer.toString(num, 2);

            convertCnt++;
        }

        result[0] = convertCnt;
        result[1] = removedZeroCnt;

        return result;
    }

}
