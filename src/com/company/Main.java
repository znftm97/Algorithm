package com.company;

import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int a= 2;
        int b= 3;
        int n= 8;
        int count = 1;
        Stack<Integer> st = new Stack<>();
        a -= 1;
        b -= 1;

        while (true) {
            if (0 == a || 0 == b) {
                st.add(1);
            } else {
                st.add(0);
            }

            for (int i = 1; i < n; i++) {
                if (st.peek() == 1 && (i == a || i == b) && i%2!=0) {
                        System.out.println(count);
                        return;
                    }


                if (i == a || i == b) {
                    st.add(1);
                } else {
                    st.add(0);
                }
            }

            st.clear();
            count++;
            n = n/2;
            a = a/2;
            b = b/2;
        }

    }
}

