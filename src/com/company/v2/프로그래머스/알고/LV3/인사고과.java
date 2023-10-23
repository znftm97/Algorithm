package com.company.v2.프로그래머스.알고.LV3;

import java.util.*;

public class 인사고과 {
    static class Employee {
        int id;
        int scoreA;
        int scoreB;

        public Employee (int id, int scoreA, int scoreB) {
            this.id=id;
            this.scoreA=scoreA;
            this.scoreB=scoreB;
        }
    }

    public int solution(int[][] scores) {
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i<scores.length; i++) {
            int scoreA = scores[i][0];
            int scoreB = scores[i][1];
            employees.add(new Employee(i,scoreA,scoreB));
        }

        employees.sort((o1, o2) -> o1.scoreA == o2.scoreA ?
                Integer.compare(o1.scoreB, o2.scoreB) :
                Integer.compare(o2.scoreA, o1.scoreA)
        );

        int max = 0;
        List<Employee> toBeRemoved = new ArrayList<>();
        for(Employee em : employees) {
            if(em.scoreB < max) {
                toBeRemoved.add(em);
            } else {
                max = em.scoreB;
            }
        }
        employees.removeAll(toBeRemoved);

        employees.sort((o1, o2) -> Integer.compare(o2.scoreA + o2.scoreB, o1.scoreA + o1.scoreB));

        int rank = 1;
        boolean flag = false;
        for(Employee em : employees) {
            if(em.id == 0) {
                flag = true;
                break;
            }
            rank++;
        }

        return flag ? rank : -1;
    }
}
