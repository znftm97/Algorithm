package com.company.v2.릿코드.알고리즘.easy;

import java.util.ArrayList;
import java.util.List;

public class _412 {

    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String element = "";

            if (i % 3 == 0 && i % 5 == 0) element = "FizzBuzz";
            else if(i % 3 == 0) element = "Fizz";
            else if (i%5==0) element = "Buzz";
            else element = String.valueOf(i);

            results.add(element);
        }

        return results;
    }

}
