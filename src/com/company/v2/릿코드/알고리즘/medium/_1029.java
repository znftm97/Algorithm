package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class _1029 {
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        int aCity = 0;
        int bCity = 0;
        boolean[][] visited = new boolean[costs.length][2];

        Arrays.sort(costs, Comparator.comparingInt(o -> Math.abs(o[0] - o[1])));

        for(int i = 0; i< costs.length; i++) {
            if(costs[i][0] < costs[i][1]) {
                minCost += costs[i][0];
                aCity++;
                visited[i][0] = true;
            } else {
                minCost += costs[i][1];
                bCity++;
                visited[i][1] = true;
            }
        }

        if(aCity == bCity) {
            return minCost;
        }

        int i = 0;
        while(true) {
            if(aCity == bCity) break;

            if(aCity < bCity && !visited[i][0]) {
                minCost += Math.abs(costs[i][0] - costs[i][1]);
                aCity++;
                bCity--;
            } else if (aCity > bCity && !visited[i][1]) {
                minCost += Math.abs(costs[i][0] - costs[i][1]);
                aCity--;
                bCity++;
            }

            i++;
        }

        return minCost;
    }
}
