package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _1834 {
    private int time = 1;
    private int resultIdx = 0;
    private int workIdx = 0;
    private int[] result;
    List<Work> works = new ArrayList<>();
    private Queue<Work> q = new PriorityQueue<>();

    private class Work implements Comparable<Work>{
        int idx, enqueueTime, processingTime;

        public Work(int idx, int enqueueTime, int processingTime) {
            this.idx = idx;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }

        @Override
        public int compareTo(Work o) {
            if (this.processingTime == o.processingTime) {
                return Integer.compare(this.idx, o.idx);
            }

            return Integer.compare(this.processingTime, o.processingTime);
        }
    }

    public int[] getOrder(int[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            works.add(new Work(i, tasks[i][0], tasks[i][1]));
        }
        works.sort(Comparator.comparingInt(o -> o.enqueueTime));
        result = new int[tasks.length];

        while (resultIdx < works.size()) {
            addProcessInQ();
            work();
        }

        return result;
    }

    private void addProcessInQ() {
        while (workIdx < works.size() && works.get(workIdx).enqueueTime <= time) {
            Work work = works.get(workIdx);
            q.add(work);
            workIdx++;
        }

        if (q.isEmpty()) {
            time = works.get(workIdx).enqueueTime;
        }
    }

    private void work() {
        if(q.isEmpty()) {
            return;
        }

        Work work = q.poll();
        time += work.processingTime;
        result[resultIdx++] = work.idx;
    }
}
