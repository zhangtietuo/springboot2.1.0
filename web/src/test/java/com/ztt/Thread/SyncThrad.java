package com.ztt.Thread;

class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        System.out.println(count);
        count = 0;
    }

    public  void run() {
        System.out.println(Thread.currentThread().getName()+ "====RUN");
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}
