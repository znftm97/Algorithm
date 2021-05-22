package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {70, 80, 50};
        System.out.println(solution(arr, 100));
    }
    public static int solution(int[] people, int limit) {
        int max = people.length - 1;
        int min = 0;
        int count = 0;
        Arrays.sort(people);

        while (true) {
            if (max < min){
                break;
            } else if (max == min) {
                count++;
                break;
            }

            if (people[min] + people[max] > limit) {
                max--;
                count++;
            } else{
                min++;
                max--;
                count++;
            }
        }

        return count;
    }
}