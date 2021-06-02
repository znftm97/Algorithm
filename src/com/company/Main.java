package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int n = 5;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            count++;
        }
    }
}
