package com.company.v1.프로그래머스.LV3;

import java.text.SimpleDateFormat;
import java.util.*;

public class 추석트래픽 {
    public int solution(String[] lines) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] counts = new int[lines.length];
        int max = 0;

        for(int i=0; i<lines.length; i++) {
            String[] pre = lines[i].split(" ");
            Date preEndDate = format.parse(pre[1]);
            long preEnd = preEndDate.getTime(); // 이전 로그 처리가 끝나는 시간

            for (int j = i ; j < lines.length; j++) {
                String[] next = lines[j].split(" ");
                Date nextEndDate = format.parse(next[1]);

                double processingTime = Double.parseDouble(next[2].substring(0, next[2].length() - 1)); // 맨뒤 s 제거

                long nextStart = (long) (nextEndDate.getTime() - processingTime * 1000 + 1); // 다음 로그 시작 시간

                if(preEnd + 1000 > nextStart) {
                    counts[i] += 1;
                    max = Math.max(max, counts[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        String[] arr = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        추석트래픽 asd = new 추석트래픽();
        int a = asd.solution(arr);

        System.out.println(a);
    }

}
