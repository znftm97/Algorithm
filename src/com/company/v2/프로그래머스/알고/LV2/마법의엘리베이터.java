package com.company.v2.프로그래머스.알고.LV2;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int magicStone = 0;

        while (storey > 0) {
            int oneDigit = storey % 10;
            int tenDigit = (storey / 10) % 10;

            if(oneDigit > 5) {
                magicStone += 10 - oneDigit;
                storey += 10;
            } else if(oneDigit < 5) {
                magicStone += oneDigit;
            } else {
                magicStone += 5;
                storey += tenDigit >= 5 ? 10 : 0;
            }

            storey /= 10;
        }

        return magicStone;
    }
}
