package com.company.v2.릿코드.알고리즘.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1801 {
    private class Order implements Comparable<Order>{
        int price, amount;

        public Order(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }

        @Override
        public int compareTo(Order o) {
            return Integer.compare(this.price, o.price);
        }
    }

    private final int BUY = 0;
    private final int MOD = 1000000007;
    Queue<Order> buyBacklogs = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Order> sellBacklogs = new PriorityQueue<>();

    public int getNumberOfBacklogOrders(int[][] orders) {
        for (int[] order : orders) {
            int nowPrice = order[0];
            int nowAmount = order[1];
            int orderType = order[2];

            if (orderType == BUY) {
                buy(new Order(nowPrice, nowAmount));
            } else {
                sell(new Order(nowPrice, nowAmount));
            }
        }

        long result = 0;
        for (Order o : buyBacklogs) {
            result += o.amount;
            result %= MOD;
        }
        for (Order o : sellBacklogs) {
            result += o.amount;
            result %= MOD;
        }
        return (int) (result % MOD);
    }

    private void buy(Order nowOrder) {
        if(sellBacklogs.isEmpty()) {
            buyBacklogs.add(nowOrder);
            return;
        }

        while (!sellBacklogs.isEmpty() && nowOrder.amount > 0 && nowOrder.price >= sellBacklogs.peek().price) {
            Order sellBacklog = sellBacklogs.remove();

            if (nowOrder.amount >= sellBacklog.amount) {
                nowOrder.amount -= sellBacklog.amount;
                sellBacklog.amount = 0;
            } else {
                sellBacklog.amount -= nowOrder.amount;
                sellBacklogs.add(sellBacklog);
                nowOrder.amount = 0;
            }
        }
        if(nowOrder.amount > 0) buyBacklogs.add(nowOrder);
    }

    private void sell(Order nowOrder) {
        if(buyBacklogs.isEmpty()) {
            sellBacklogs.add(nowOrder);
            return;
        }

        while (!buyBacklogs.isEmpty() && nowOrder.amount > 0 && nowOrder.price <= buyBacklogs.peek().price) {
            Order buyBacklog = buyBacklogs.remove();

            if (nowOrder.amount >= buyBacklog.amount) {
                nowOrder.amount -= buyBacklog.amount;
                buyBacklog.amount = 0;
            } else {
                buyBacklog.amount -= nowOrder.amount;
                buyBacklogs.add(buyBacklog);
                nowOrder.amount = 0;
            }
        }
        if(nowOrder.amount > 0) sellBacklogs.add(nowOrder);
    }
}
