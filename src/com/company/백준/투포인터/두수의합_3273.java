package com.company.백준.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int start = 0, end = n-1;
        int count = 0;
        int sum = 0;

        while (true) {
            sum = arr[start] + arr[end];

            if (start == end) break;//탈출조건

            /*sum이 목표값과 같을때 카운팅하고, start++ 그리고 end--를 수행하면 안된다. 둘중에 하나만해야한다.
             * 예를들어 목표값이 10일 때 둘 다 수행한다면 arr[start] = 1, arr[end] = 9 였다면 카운팅 후 sum은 arr[start+1] + end[end-1] 가 될것이다.
             * 생각해보면 목표값이 나온경우에는 한쪽값만 움직여서 절대 목표값이 나올 수 없다. 따라서 start++, end--를 수행했는데 문제가있다.
             * 바로 주어진 수열이 2개일때 문제가 발생한다. 목표값 = 2, 수열 1,1 일 때 start++ end--를 수행하게되면
             * start와 end값이 서로 교차하게되고 탈출조건을 영원히 만족하지 못하게되고 결국 배열 인덱스 에러가 난다.
             * 따라서 start++ 또는 end-- 하나만 수행해야한다.
             * */
            if (sum == x) {
                count++;
                start++;
            }

            if (sum > x) end--;
            else if (sum < x) start++;
        }

        System.out.println(count);
    }
}
