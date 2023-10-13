package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 파일명정렬 {
    static class File implements Comparable<File> {
        String head;
        String num;
        String tail;

        public File(String head, String num, String tail) {
            this.head=head;
            this.num=num;
            this.tail=tail;
        }

        @Override
        public int compareTo(File f) {
            if(this.head.equalsIgnoreCase(f.head)) {
                int num1 = Integer.parseInt(this.num);
                int num2 = Integer.parseInt(f.num);
                return Integer.compare(num1, num2);
            }

            return this.head.toLowerCase().compareTo(f.head.toLowerCase());
        }
    }

    public String[] solution(String[] files) {
        List<File> convertFiles = new ArrayList<>();

        for(String file : files) {
            convertFiles.add(generateFile(file));
        }

        Collections.sort(convertFiles);

        String[] results = new String[convertFiles.size()];
        int idx = 0;
        for(File file : convertFiles) {
            results[idx++] = file.head + file.num + file.tail;
        }

        return results;
    }

    static File generateFile(String file) {
        String head = "";
        String num = "";
        String tail = "";

        int numStartIdx = 0;
        int numEndIdx = 0;
        for(int i = 0; i<file.length(); i++) {
            if(Character.isDigit(file.charAt(i))) {
                numStartIdx = i;

                while(i < file.length()) {
                    if(!Character.isDigit(file.charAt(i++))) {
                        numEndIdx = i - 1;
                        break;
                    }
                }

                break;
            }
        }

        head = file.substring(0, numStartIdx);

        if(numEndIdx == 0) {
            num = file.substring(numStartIdx);
            tail = "";
        } else {
            num = file.substring(numStartIdx, numEndIdx);
            tail = file.substring(numEndIdx);
        }

        return new File(head, num, tail);
    }
}
