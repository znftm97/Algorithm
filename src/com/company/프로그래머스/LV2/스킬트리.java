package com.company.프로그래머스.LV2;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int result = skill_trees.length;
        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            startIdx = skill_trees[i].indexOf(skill.charAt(0));

            for (int j = 1; j < skill.length(); j++) {
                endIdx = skill_trees[i].indexOf(skill.charAt(j));

                if(isAbleSkillTree(startIdx, endIdx)) {
                    result--;
                    break;
                }

                startIdx = endIdx;
            }
        }

        return result;
    }

    private static boolean isAbleSkillTree(int startIdx, int endIdx) {
        return (startIdx > endIdx && endIdx != -1) || (startIdx == -1 && endIdx != -1);
    }

}
