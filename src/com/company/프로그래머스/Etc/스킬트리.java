package com.company.프로그래머스.Etc;

import java.io.IOException;

public class 스킬트리 {
    public static void main(String[] args) throws IOException {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        int result = skill_trees.length;
        int sIndex = 0;
        int eIndex = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            sIndex = skill_trees[i].indexOf(skill.charAt(0));

            for (int j = 1; j < skill.length(); j++) {
                eIndex = skill_trees[i].indexOf(skill.charAt(j));

                if((sIndex > eIndex && eIndex != -1) || (sIndex == -1 && eIndex != -1)) {
                    result--;
                    break;
                }

                sIndex = eIndex;
            }
        }

        System.out.println(result);
    }
}
