package com.company.프로그래머스.LV2;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*재생시간이 가장 긴 음악을 반환하기위해 Music 클래스에서 재생시간 기준 내림차순 정렬
 * 재생시간이 같을경우 먼저 입력된 음악을 반환하기위해 우선순위큐 사용
 * */
public class _3차방금그곡 {

    private static class Music implements Comparable<Music>{
        String title;
        int playTime;

        public Music(String title, int playTime) {
            this.title = title;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Music m) {
            return Integer.compare(m.playTime, this.playTime);
        }
    }

    public String solution(String m, String[] musicinfos) {
        PriorityQueue<Music> pq = new PriorityQueue<>();
        m = convertMelody(m);

        for (String s : musicinfos) {
            StringTokenizer st = new StringTokenizer(s, ",");

            String startTime = st.nextToken();
            String endTime = st.nextToken();
            int totalPlayTime = getTotalPlayTime(startTime, endTime);

            String title = st.nextToken();
            String melody = st.nextToken();
            melody = convertMelody(melody);
            String totalMelody = getTotalMelody(totalPlayTime, melody);

            if (totalMelody.contains(m)) pq.add(new Music(title, totalPlayTime));
        }

        if(pq.isEmpty()) return "(None)";
        return pq.poll().title;
    }

    /*#붙은 음은 하나의 소문자로 치환*/
    private static String convertMelody(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");

        return s.replaceAll("A#", "a");
    }

    /*문제에서 주어진 시간의 최소단위인 분으로 변환해서 재생시간 계산*/
    private static int getTotalPlayTime(String startTime, String endTime){
        int startPlayTime = Integer.parseInt(startTime.substring(0, 2)) * 60 + Integer.parseInt(startTime.substring(3, 5));
        int endPlayTime = Integer.parseInt(endTime.substring(0, 2)) * 60 + Integer.parseInt(endTime.substring(3, 5));

        return endPlayTime - startPlayTime;
    }

    /*재생시간만큼 반복된 멜로디 계산, 한 음마다 반복돌리지않고 재생시간을 길이로 나눠서 계산*/
    private static String getTotalMelody(int totalPlayTime, String melody){
        StringBuilder sb = new StringBuilder();
        int repeatCnt = totalPlayTime / melody.length();
        int modular = totalPlayTime % melody.length();

        if (repeatCnt == 0) return melody.substring(0, totalPlayTime); // 재생시간이 멜로디 길이보다 적은경우

        for (int i = 0; i < repeatCnt; i++) sb.append(melody);
        if (modular != 0) sb.append(melody.substring(0, modular + 1));

        return sb.toString();
    }
}
