package com.company.해커랭크.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmartNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.valueOf(br.readLine());
        int count = 0;

        for(int i =0; i<t; i++){
            int num = Integer.valueOf(br.readLine());
            if(num == 1){
                sb.append("YES").append("\n");
                continue;
            }

            for(int j = 2; j<num; j++){
                if(num%j == 0){
                    count++;
                }
            }

            if(count%2==0){
                sb.append("NO").append("\n");
            } else{
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
