package com.company.v2.백준.랜덤문제풀이.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int videoCount = Integer.parseInt(st.nextToken());
        int blueRayCount = Integer.parseInt(st.nextToken());
        int[] videos = new int[videoCount];

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < videoCount; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            end += videos[i];
            start = Math.max(start, videos[i]);
        }

        while(start <= end){
            int blueRaySize = start + (end - start) / 2;
            int usedBlueRayCount = getUsedBlueRayCount(videos, blueRaySize);

            if(usedBlueRayCount <= blueRayCount){
                end = blueRaySize - 1;
            } else {
                start = blueRaySize + 1;
            }
        }

        System.out.println(start);
    }

    private static int getUsedBlueRayCount(int[] videos, int blueRaySize) {
        int sum = 0;
        int usedBlueRayCount = 0;

        for(int i = 0; i<videos.length; i++){
            if(sum + videos[i] > blueRaySize){
                usedBlueRayCount++;
                sum = 0;
            }
            sum += videos[i];
        }

        return sum > 0 ? usedBlueRayCount + 1 : usedBlueRayCount;
    }
}
