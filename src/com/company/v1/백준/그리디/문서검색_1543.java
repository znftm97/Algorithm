package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String originStr = br.readLine();
        String pattern = br.readLine();
        int cnt = 0;

        while (true) {
            if (!originStr.contains(pattern)) {
                break;
            }

            originStr = originStr.replaceFirst(pattern, " "); // ""로 하는경우, 문서가 aabb이고 패턴이 ab인경우 -> 2번카운트하게됨
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

}
