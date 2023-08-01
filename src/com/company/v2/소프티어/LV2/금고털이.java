package com.company.v2.소프티어.LV2;

import java.util.*;
import java.io.*;

public class 금고털이 {

    public class Main{
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int bag = Integer.parseInt(st.nextToken());
            int jewelryCnt = Integer.parseInt(st.nextToken());
            int[][] arr = new int[jewelryCnt][2];

            for(int i = 0; i<jewelryCnt; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[1], o1[1]));

            int result = 0;
            for(int i = 0; i<arr.length; i++){
                int weight = arr[i][0];
                int price = arr[i][1];

                if(bag <= weight) {
                    result += bag * price;
                    break;
                } else {
                    result += weight * price;
                    bag -= weight;
                }
            }

            System.out.println(result);
        }
    }
}
