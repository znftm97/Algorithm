package com.company.프로그래머스.문자열;

import java.io.IOException;

public class 숫자문자열과영단어 {
    public static void main(String[] args) throws IOException {
        String s = "one4seveneight";
        String[] numStrs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < 10; i++) {
            if(s.contains(numStrs[i])){
                s = s.replace(numStrs[i], nums[i]);
            }
        }

        System.out.println(s);
    }
}
