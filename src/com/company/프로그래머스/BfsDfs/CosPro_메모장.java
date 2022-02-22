package com.company.프로그래머스.BfsDfs;

public class CosPro_메모장 {
    public int solution(int K, String[] words) {
        int result = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<words.length; i++){
            String word = words[i];

            if(sb.length() == 0){
                sb.append(word).append("_");
                result++;
                continue;
            }

            if(sb.length() + word.length() <= K){
                sb.append(word).append("_");
            } else{
                result++;
                sb.setLength(0);
                sb.append(word).append("_");
            }
        }

        return result;
    }

}
