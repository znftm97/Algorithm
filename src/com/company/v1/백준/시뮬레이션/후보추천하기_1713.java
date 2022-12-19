package com.company.v1.백준.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 후보추천하기_1713 {
    static class Student implements Comparable<Student>{
        int num;
        int recommend;
        int young;

        public Student(int num, int recommend, int young) {
            this.num = num;
            this.recommend = recommend;
            this.young = young;
        }

        @Override
        public int compareTo(Student s) {
            if (this.recommend == s.recommend) {
                return Integer.compare(this.young, s.young);
            }
            return Integer.compare(this.recommend, s.recommend);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Student> students = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int studentNum = Integer.parseInt(st.nextToken());

            if (students.size() < N) { // 액자가 남는 경우
                boolean isSame = false;
                for (Student s : students) { // 이미 액자에 있는 학생
                    if (s.num == studentNum) {
                        s.recommend++;
                        isSame = true;
                    }
                }

                if (!isSame) { // 새 학생
                    students.add(new Student(studentNum, 1, i));
                }
            }
            else { // 액자가 꽉찬 경우
                boolean isSame = false;

                for (Student s : students) { // 이미 액자에 있는 학생
                    if (s.num == studentNum) {
                        s.recommend++;
                        isSame = true;
                    }
                }

                if (!isSame) { // 추천수가 제일적은경우 또는 같다면 제일 오래된 학생 제거 후, 새 학생 추가
                    Collections.sort(students);
                    students.remove(0);
                    students.add(new Student(studentNum, 1, i));
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for (Student s : students) {
            result.add(s.num);
        }

        Collections.sort(result);

        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}
