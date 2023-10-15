package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 방금그곡 {
    static class Music implements Comparable<Music> {
        int playTime;
        String title;
        String melody;

        public Music(int playTime, String title, String melody) {
            this.playTime = playTime;
            this.title=title;
            this.melody=melody;
        }

        @Override
        public int compareTo(Music m) {
            return Integer.compare(m.playTime, this.playTime);
        }
    }

    public String solution(String m, String[] musicinfos) {
        List<Music> musics = new ArrayList<>();

        for(String musicInfo : musicinfos) {
            String[] splits = musicInfo.split(",");
            String startTime = splits[0];
            String endTime = splits[1];
            String title = splits[2];
            String melody = splits[3];
            int playTime = calculatePlayTime(startTime, endTime);

            if(isFindMusic(melody, m, playTime)) {
                musics.add(new Music(playTime, title, melody));
            }
        }

        if(musics.isEmpty()) {
            return "(None)";
        }

        Collections.sort(musics);

        return musics.get(0).title;
    }

    static int calculatePlayTime(String startTimeStr, String endTimeStr) {
        String[] splits1 = startTimeStr.split(":");
        int startTime = Integer.parseInt(splits1[0]) * 60 + Integer.parseInt(splits1[1]);

        String[] splits2 = endTimeStr.split(":");
        int endTime = Integer.parseInt(splits2[0]) * 60 + Integer.parseInt(splits2[1]);

        return endTime - startTime;
    }

    static boolean isFindMusic(String melody, String targetMelody, int playTime) {
        melody = convert(melody);
        targetMelody = convert(targetMelody);
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int pt = 0; pt<playTime; pt++) {
            sb.append(melody.charAt(idx++));
            idx %= melody.length();
        }
        melody = sb.toString();

        return melody.contains(targetMelody);
    }

    static String convert(String s) {
        return s.replaceAll("A#", "1")
                .replaceAll("C#", "2")
                .replaceAll("D#", "3")
                .replaceAll("F#", "4")
                .replaceAll("G#", "5");
    }
}
