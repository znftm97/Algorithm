package com.company.v1.백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        String reversA = new StringBuffer(A).reverse().toString();
        String reversB = new StringBuffer(B).reverse().toString();

        int numA = Integer.parseInt(reversA);
        int numB = Integer.parseInt(reversB);

        if(numA > numB){
            System.out.println(numA);
        }else{
            System.out.println(numB);
        }
    }
}