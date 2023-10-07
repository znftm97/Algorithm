package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        Queue<Character> q = new LinkedList<>();
        Set<Character> set = new HashSet();
        for(char c : skill.toCharArray()) {
            q.add(c);
            set.add(c);
        }

        int result = 0;
        for(String skillTree : skill_trees) {
            Queue<Character> copyQ = new LinkedList<>(q);
            boolean isSkillTree = true;

            for(char c : skillTree.toCharArray()) {
                if(set.contains(c)) {
                    if(!copyQ.isEmpty() && copyQ.peek() == c) {
                        copyQ.poll();
                    } else {
                        isSkillTree = false;
                        break;
                    }
                }
            }

            if(isSkillTree) {
                result++;
            }
        }

        return result;
    }
}
