package com.company.v1.프로그래머스.구현;

public class 키패드누르기_LV1 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftNum = 10;
        int rightNum = 12;

        for(int i = 0; i<numbers.length; i++){
            int num = numbers[i];

            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftNum = num;
            } else if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                rightNum = num;
            } else{
                int leftLen = getLen(num, leftNum);
                int rightLen = getLen(num, rightNum);

                if(leftLen == rightLen){
                    if(hand.equals("left")) {
                        sb.append("L");
                        leftNum = num;
                    }else {
                        sb.append("R");
                        rightNum = num;
                    }
                } else if (leftLen > rightLen){
                    sb.append("R");
                    rightNum = num;
                } else{
                    sb.append("L");
                    leftNum = num;
                }
            }
        }

        return sb.toString();
    }

    private int getLen(int target, int nowNum){
        if(target == 0) target = 11;
        if(nowNum == 0) nowNum = 11;

        return (Math.abs(target - nowNum))/3 + (Math.abs(target - nowNum))%3;
    }
}
