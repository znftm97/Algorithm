package com.company.백준.기타.실4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int recentNum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    recentNum = Integer.parseInt(st.nextToken());
                    q.add(recentNum);
                    break;
                case "pop":
                    if(!q.isEmpty()) sb.append(q.poll()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(!q.isEmpty()) sb.append(q.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if(!q.isEmpty()) sb.append(recentNum).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
