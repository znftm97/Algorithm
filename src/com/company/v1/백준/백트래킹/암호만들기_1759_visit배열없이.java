package com.company.v1.백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759_visit배열없이 {
    private static StringBuilder sb = new StringBuilder();
    private static String[] alphabets;
    private static String[] keys;
    private static int keyLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        keyLen = Integer.parseInt(st.nextToken());
        int alphabetCnt = Integer.parseInt(st.nextToken());

        alphabets = new String[alphabetCnt];
        keys = new String[keyLen];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < alphabetCnt; i++) {
            alphabets[i] = st.nextToken();
        }

        Arrays.sort(alphabets);

        recursion(0, 0);
    }

    private static void recursion(int depth, int start){
        if(depth == keyLen){
            int jaumCnt = 0;
            int moumCnt = 0;

            for (String keyAlphabet : keys) {
                sb.append(keyAlphabet);

                if (isMoum(keyAlphabet)) moumCnt++;
                else jaumCnt++;
            }

            if (moumCnt >= 1 && jaumCnt >= 2) System.out.println(sb);

            sb.setLength(0);
            return;
        }

        for (int i = start; i < alphabets.length; i++) {
            keys[depth] = alphabets[i];
            recursion(depth + 1, i + 1);
        }
    }

    private static boolean isMoum(String alphabet){
        return alphabet.equals("a") || alphabet.equals("e") || alphabet.equals("i") || alphabet.equals("o") || alphabet.equals("u");
    }

}
