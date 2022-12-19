package com.company.v2.백준.랜덤문제풀이.g4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열폭발_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        char[] arr = new char[str.length()];
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {
            arr[idx] = str.charAt(i);

            if (isBomb(arr, idx, bomb)){
                idx -= bomb.length();
            }

            idx++;
        }

        String result = String.valueOf(arr, 0, idx);

        System.out.println((result.length() == 0) ? "FRULA" : result);
    }

    private static boolean isBomb(char[] result, int idx, String bomb) {
        if (idx < bomb.length() - 1) {
            return false;
        }

        for (int i = 0; i < bomb.length(); i++) {
            if (bomb.charAt(i) != result[idx - bomb.length() + 1 + i]) {
                return false;
            }
        }

        return true;
    }

}
