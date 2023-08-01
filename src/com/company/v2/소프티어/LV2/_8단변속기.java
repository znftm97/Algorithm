package com.company.v2.소프티어.LV2;

import java.util.*;
import java.io.*;

public class _8단변속기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int sum = 0;
        int start = Integer.parseInt(arr[0]);

        for(int i = 0; i<arr.length - 1; i++) {
            sum += Math.abs(Integer.parseInt(arr[i]) - Integer.parseInt(arr[i + 1]));
        }

        if(sum == 7 && start == 1) System.out.println("ascending");
        else if(sum == 7 && start == 8) System.out.println("descending");
        else System.out.println("mixed");
    }
}
