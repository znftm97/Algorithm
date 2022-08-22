package com.company.v1.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 국영수_10825 {
    private static class Student implements Comparable<Student>{
        String name;
        int korean;
        int eng;
        int math;

        public Student(String name, int korean, int eng, int math) {
            this.name = name;
            this.korean = korean;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student s) {
            if (this.korean == s.korean) {
                if (this.eng == s.eng) {
                    if (this.math == s.math) {
                        return this.name.compareTo(s.name);
                    }
                    return s.math - this.math;
                }
                return this.eng - s.eng;
            }
            return s.korean - this.korean;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(students);
        for (Student s : students) {
            System.out.println(s.name);
        }
        br.close();
    }

}
