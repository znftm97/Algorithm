package com.company.v1.해커랭크.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XorStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String answer = "";

        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                answer += "0";
            }else{
                answer +="1";
            }
        }

        System.out.println(answer);
    }
}
