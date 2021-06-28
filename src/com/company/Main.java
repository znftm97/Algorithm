package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        int[][] T = {{4,3},{3,1},{2,3},{3,4}};


        Arrays.sort(T, (o1, o2) -> o1[0] - o2[0]);
        System.out.println();

    }
}



