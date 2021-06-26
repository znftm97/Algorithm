package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int[] arr = {1, 3, 5, 4, 0, 0, 7, 0, 0 ,6};
        int tc = 10;

        Stack<Integer> st = new Stack<>();
        int sum = 0;

        for (int i = 0; i < tc; i++) {
            int input = arr[i];

            if(input != 0){
                st.add(input);
            } else if(input == 0 && !st.isEmpty()){
                st.pop();
            }
        }

        for (int a : st) {
            sum += a;
        }

        System.out.println(sum);
    }
}



