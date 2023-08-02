package com.company.v2.소프티어.LV2;

import java.util.*;
import java.io.*;

public class _비밀메뉴 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int secretNumCnt = Integer.parseInt(st.nextToken());
        int useNumCnt = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String secretNum = br.readLine().trim();
        String useNum = br.readLine().trim();

        if(useNum.contains(secretNum)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }

}
