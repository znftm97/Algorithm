package com.company.v2.프로그래머스.알고.LV2;

public class 문자열압축 {
    public int solution(String s) {
        if(s.length() == 1) {
            return 1;
        }

        int result = Integer.MAX_VALUE;
        for(int len = 1; len<=s.length()/2; len++) {
            result = Math.min(result, compression(len, s));
        }

        return result;
    }

    static int compression(int len, String originStr) {
        String pattern = "";
        StringBuilder sb = new StringBuilder();
        int repeatCnt = 1;

        for (int i = 0; i <= originStr.length() + len; i += len) {
            String nowStr = "";

            if (i >= originStr.length()) {
                nowStr = "";
            } else if (originStr.length() < i + len) {
                nowStr = originStr.substring(i);
            } else{
                nowStr = originStr.substring(i, i + len);
            }

            if(nowStr.equals(pattern)){
                repeatCnt++;
            } else if (repeatCnt >= 2) {
                sb.append(repeatCnt).append(pattern);
                repeatCnt = 1;
            } else if (repeatCnt == 1) {
                sb.append(pattern);
            }

            pattern = nowStr;
        }

        return sb.length();
    }
}
