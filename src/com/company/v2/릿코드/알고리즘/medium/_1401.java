package com.company.v2.릿코드.알고리즘.medium;

public class _1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int tmpX = xCenter;
        int tmpY = yCenter;

        if(xCenter < x1) tmpX = x1;
        else if(xCenter > x2) tmpX = x2;

        if(yCenter < y1) tmpY = y1;
        else if(yCenter > y2) tmpY = y2;

        int dx = xCenter - tmpX;
        int dy = yCenter - tmpY;

        return (dx * dx + dy * dy) <= radius * radius;
    }
}
