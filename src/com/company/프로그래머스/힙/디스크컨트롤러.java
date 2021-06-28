package com.company.프로그래머스.힙;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int count = 0; // 수행된 요청 개수
        int index = 0; // jobs 배열 인덱스
        int end = 0; // 요청 끝난 시간
        int answer = 0;

        //요청시간 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        //처리 시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        //모든 요청 처리할때까지 반복
        while (count < jobs.length) {

            // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }

            // 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미 (end를 요청의 가장 처음으로 맞춰줌)
            if (pq.isEmpty()) {
                end = jobs[index][0];

            } else {// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;
            }
        }

        return (int) Math.floor(answer / jobs.length);
    }
}
