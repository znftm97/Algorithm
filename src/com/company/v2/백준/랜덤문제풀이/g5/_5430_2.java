package com.company.v2.백준.랜덤문제풀이.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5430_2 {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            String command = br.readLine();
            nums = new int[Integer.parseInt(br.readLine())];
            String s = br.readLine();
            input(s);

            int now = 0;
            int min = 0;
            int max = nums.length - 1;
            boolean flag = false;
            for(int i = 0; i<command.length(); i++) {
                if(command.charAt(i) == 'R') {
                    if(now == min) now = max;
                    else now = min;
                }

                if(command.charAt(i) == 'D') {
                    if(min > max) {
                        flag = true;
                        break;
                    }

                    if(now == min) {
                        now++;
                        min++;
                    } else {
                        now--;
                        max--;
                    }
                }
            }

            if(flag) sb.append("error").append("\n");
            else generate(now, min, max, nums);
        }

        System.out.println(sb);
    }

    static void input(String s) {
        StringTokenizer st = new StringTokenizer(s.substring(1, s.length() - 1), ",");
        int idx = 0;
        while (st.hasMoreTokens()) {
            nums[idx++] = Integer.parseInt(st.nextToken());
        }
    }

    static void generate(int now, int min, int max, int[] nums) {
        sb.append("[");
        if(now > min) {
            for(int i = max; i>=min; i--) {
                if(i == min) {
                    sb.append(nums[i]);
                    break;
                }
                sb.append(nums[i]).append(",");
            }
        } else {
            for(int i = min; i<=max; i++) {
                if(i == max) {
                    sb.append(nums[i]);
                    break;
                }
                sb.append(nums[i]).append(",");
            }
        }

        sb.append("]").append("\n");
    }
}
