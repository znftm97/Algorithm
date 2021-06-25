package com.company.해커랭크.easy;

import java.io.IOException;
import java.util.List;

public class NimGame {
    public static String nimGame(List<Integer> pile) throws IOException {
        int res = 0;

        for(int a : pile){
            res ^= a;
        }

        if(res == 0){
            return "Second";
        } else{
            return "First";
        }
    }
}
