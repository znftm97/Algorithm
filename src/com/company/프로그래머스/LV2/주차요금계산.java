package com.company.프로그래머스.LV2;

import java.util.*;

public class 주차요금계산 {

    private static class ParkingInfo implements Comparable<ParkingInfo>{
        String carNum, status;
        int inTime, stayTime, fee;

        public ParkingInfo(String carNum, String status, int inTime, int stayTime, int fee) {
            this.carNum = carNum;
            this.status = status;
            this.inTime = inTime;
            this.stayTime = stayTime;
            this.fee = fee;
        }

        @Override
        public int compareTo(ParkingInfo p) {
            return this.carNum.compareTo(p.carNum);
        }
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, ParkingInfo> parkingInfos = new HashMap<>();

        /*입출차 기록 정보 정제(머무른 시간 계산)*/
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            int time = timeConvert(st.nextToken());
            String carNum = st.nextToken();
            String status = st.nextToken();

            if(!parkingInfos.containsKey(carNum)){ // 처음 입차한 경우
                parkingInfos.put(carNum, new ParkingInfo(carNum, status, time, 0, 0));
            } else if (parkingInfos.containsKey(carNum) && status.equals("IN")) { // 이미 입출차한 차량이, 다시 입차한 경우
                ParkingInfo parkingInfo = parkingInfos.get(carNum);
                parkingInfo.status = status;
                parkingInfo.inTime = time;
            } else if (parkingInfos.containsKey(carNum) && status.equals("OUT")) { // 입차한 차량이 출차하는 경우
                ParkingInfo parkingInfo = parkingInfos.get(carNum);
                parkingInfo.status = status;
                parkingInfo.stayTime += time - parkingInfo.inTime; // 주차장에 머무른 시간 계산
            }
        }

        /*입차한 후 출차 안한 차량 출차처리*/
        for (String carNum : parkingInfos.keySet()) {
            ParkingInfo parkingInfo = parkingInfos.get(carNum);
            if (parkingInfo.status.equals("IN")) {
                parkingInfo.stayTime += 1439 - parkingInfo.inTime; // 23:59(1439)분에 출차한것으로 간주
            }
        }

        /*요금 계산*/
        for (String carNum : parkingInfos.keySet()) {
            ParkingInfo parkingInfo = parkingInfos.get(carNum);
            if (parkingInfo.stayTime - fees[0] < 0) { // 기본시간보다 작은경우 기본요금만 받음
                parkingInfo.fee = fees[1];
                continue;
            }

            parkingInfo.fee = fees[1] + (int) Math.ceil((double) (parkingInfo.stayTime - fees[0]) / fees[2]) * fees[3];
        }

        /*주차 요금 출력*/
        List<ParkingInfo> parkingFees = new ArrayList<>(parkingInfos.values());
        Collections.sort(parkingFees);

        int[] result = new int[parkingFees.size()];
        for (int i = 0; i < parkingFees.size(); i++) {
            result[i] = parkingFees.get(i).fee;
        }

        return result;
    }

    private static int timeConvert(String time){
        return (Integer.parseInt(time.substring(0, 2)) * 60) + Integer.parseInt(time.substring(3, 5));
    }


}
