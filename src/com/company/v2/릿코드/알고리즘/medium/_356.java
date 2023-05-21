package com.company.v2.릿코드.알고리즘.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _356 {
    private class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public boolean isReflected(int[][] points) {
        Set<Point> reflectPoints = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] point : points) {
            reflectPoints.add(new Point(point[0], point[1]));
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
        }

        int sum = max + min;
        for (int[] point : points) {
            Point p = new Point(sum - point[0], point[1]);
            reflectPoints.remove(p);
        }

        return reflectPoints.isEmpty();
    }
}
