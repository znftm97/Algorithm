package com.company.v1.백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠핑_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int availableDay = Integer.parseInt(st.nextToken());
            int continuousDay = Integer.parseInt(st.nextToken());
            int totalDay = Integer.parseInt(st.nextToken());

            if(availableDay == 0 && continuousDay == 0 && totalDay == 0){
                break;
            }

            int continuousCount = totalDay / continuousDay;
            int restDay = (totalDay - (continuousDay * continuousCount));

            if (restDay > availableDay) { // 남은 일수가 연속으로 사용가능한 일수를 초과하면 안됨
                restDay = availableDay;
            }

            int result = (continuousCount * availableDay) + restDay;
            sb.append("Case " + i++ + ": " + result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}
