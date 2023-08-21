package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] phoneNums = new String[N];

            for(int i = 0; i<N; i++) {
                phoneNums[i] = br.readLine();
            }

            Arrays.sort(phoneNums);

            boolean isNotContain = true;
            for(int i = 0; i<N - 1; i++) {
                if(phoneNums[i + 1].startsWith(phoneNums[i])) {
                    System.out.println("NO");
                    isNotContain = false;
                    break;
                }
            }

            if(isNotContain) System.out.println("YES");
        }
    }
}
