package com.company.v1.해커랭크.easy;

import java.io.IOException;

public class 문자열압축_다시풀이 {
    public static void main(String[] args) throws IOException {
        String originStr = "abcaaabbbcc";
        StringBuilder sb = new StringBuilder();
        int overlapCount = 1;

        for (int i = 0; i < originStr.length() - 1; i++) {

            if (originStr.charAt(i) == originStr.charAt(i + 1)) {
                overlapCount++;
            } else if(overlapCount == 1){
                sb.append(originStr.charAt(i));
            } else if (overlapCount > 1) {
                sb.append(originStr.charAt(i)).append(overlapCount);
                overlapCount = 1;
            }

            if ((i == originStr.length() - 2) && overlapCount > 1) { // 마지막 문자인 경우
                sb.append(originStr.charAt(i)).append(overlapCount);
            }
        }

        System.out.println(sb);
    }
}
