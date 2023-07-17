package com.company.v2.릿코드.알고리즘.medium;

import java.util.*;

public class SnakeGame_353 {

    private int R, C;
    private Queue<Point> foods;
    private Deque<Point> snakePoints;

    private enum Move{
        U(-1,0), D(1,0), L(0,-1), R(0, 1);
        int r, c;

        Move(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

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

    public SnakeGame_353(int width, int height, int[][] food) {
        R = height;
        C = width;
        foods = new LinkedList<>();
        snakePoints = new LinkedList<>();
        snakePoints.add(new Point(0, 0));
        for (int i = 0; i < food.length; i++) {
            foods.add(new Point(food[i][0], food[i][1]));
        }
    }

    public int move(String direction) {
        Move move = Move.valueOf(direction);
        Point head = snakePoints.peekLast();

        int nr = head.r + move.r;
        int nc = head.c + move.c;
        Point nextPoint = new Point(nr, nc);

        if (isEndGame(nextPoint)) {
            return -1;
        }

        snakePoints.addLast(nextPoint);

        if (hasFood(nextPoint)) foods.poll();
        else snakePoints.pollFirst();

        return snakePoints.size() - 1;
    }

    private boolean isEndGame(Point nextPoint) {
        if (!(nextPoint.r >= 0 && nextPoint.c >= 0 && nextPoint.r < R && nextPoint.c < C)) {
            return true;
        }

        Deque<Point> snakePointsWithoutTail = new LinkedList<>(snakePoints);
        snakePointsWithoutTail.pollLast();

        return snakePointsWithoutTail.contains(nextPoint);
    }

    private boolean hasFood(Point nextPoint) {
        if(foods.isEmpty()) return false;

        return foods.peek().equals(nextPoint);
    }
}
