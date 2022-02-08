package com.company.프로그래머스.LV2;

import java.util.PriorityQueue;

public class _3차파일명정렬 {

    private static class File implements Comparable<File>{
        int index;
        String head;
        String num;
        String tail;

        public File(int index, String head, String num, String tail) {
            this.index = index;
            this.head = head;
            this.num = num;
            this.tail = tail;
        }

        @Override
        public int compareTo(File f) {
            if (this.head.equalsIgnoreCase(f.head)) { // 문자열 같으면
                int beforeNum = Integer.parseInt(this.num);
                int afterNum = Integer.parseInt(f.num);

                if((beforeNum == afterNum)) return Integer.compare(this.index, f.index); // 문자, 숫자 다 같으면 순서대로
                else return Integer.compare(beforeNum, afterNum); // 문자 같고, 숫자 다르면 숫자 오름차순으로
            }

            return this.head.compareToIgnoreCase(f.head); // 문자열 다르면 사전순 정렬
        }

        @Override
        public String toString() {
            return this.head + this.num + this.tail;
        }
    }

    public String[] solution(String[] files){
        PriorityQueue<File> pq = new PriorityQueue<>();
        String[] result = new String[files.length];

        int index = 0;
        for (String file : files) {
            String head = "";
            String num = "";

            int hIndex = 0;
            for (int i = 0; i < file.length(); i++) {
                if(Character.isDigit(file.charAt(i))){
                    head = file.substring(0, i);
                    hIndex = i;
                    break;
                }
            }

            int nIndex = 0;
            for (int i = hIndex; i < file.length(); i++) {
                if (!Character.isDigit(file.charAt(i))) {
                    num = file.substring(hIndex, i);
                    nIndex = i;
                    break;
                } else if (i == file.length() - 1) { // 끝까지 탐색한경우, 즉 tail이 없는경우
                    num = file.substring(hIndex);
                    nIndex = i;
                    break;
                }
            }

            if (nIndex == file.length() - 1) pq.add(new File(index++, head, num, "")); // 다 탐색해서, tail 없는 경우
            else pq.add(new File(index++, head, num, file.substring(nIndex))); // tail 남은 경우
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll().toString();
        }

        return result;
    }

}
