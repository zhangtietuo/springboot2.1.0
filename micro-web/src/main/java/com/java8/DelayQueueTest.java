package com.java8;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2022/8/18 10:06
 */
@Slf4j
public class DelayQueueTest {

    public static void main(String[] args) {
        final DelayQueue<DelayedEvent> delayQueue = new DelayQueue<>();
        final long timeFirst = System.currentTimeMillis() + 10000;
        delayQueue.offer(new DelayedEvent(timeFirst, "1"));
        delayQueue.offer(new DelayedEvent(timeFirst-5000, "2"));
        System.out.println("Done");
        try {
            log.info(delayQueue.take().getMsg());
            //Thread.sleep(10000);
            log.info(delayQueue.take().getMsg());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    static class DelayedEvent implements Delayed {

        private long startTime;
        private String msg;

        public DelayedEvent(long startTime, String msg) {
            this.startTime = startTime;
            this.msg = msg;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.startTime - ((DelayedEvent) o).startTime);
        }


    }
}