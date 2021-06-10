package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 45;
        String answer = "";

        while(n > 0){
            answer = (n % 3) + answer;
            n /= 3;
        }
        answer = new StringBuilder(answer).reverse().toString();


        System.out.println(Integer.parseInt(answer,3));
    }
}

