package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] position;
    static boolean[] check;
    static int ans;

    public static void main(String[] args) throws IOException {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        position = new char[8];
        check = new boolean[8];
        ans = 0;

        backtracking(0, n, data);
    }

    static void backtracking(int idx, int n, String[] data){
        if(idx == 8){
            if(isPossible(n, data)){
                ans++;
            }
            return;
        }

        for(int i = 0 ; i < 8 ; ++i){
            if(!check[i]){
                check[i] = true;
                position[idx] = character[i];
                backtracking(idx + 1, n, data);
                check[i] = false;
            }
        }
    }

    static boolean isPossible(int n, String[] data){
        for(int i = 0 ; i < n ; ++i){
            char[] condition = data[i].toCharArray();
            int from = 0, to = 0, gap = 0, cond = condition[4] - '0';

            for(int j = 0 ; j < 8 ; ++j){
                if(position[j] == condition[0]) from = j;
                if(position[j] == condition[2]) to = j;
            }

            gap = Math.abs(from - to) - 1;
            switch(condition[3]){
                case '=':
                    if(gap != cond) return false;
                    break;
                case '<':
                    if(gap >= cond) return false;
                    break;
                case '>':
                    if(gap <= cond) return false;
                    break;
            }
        }
        return true;
    }
}

