package thread.high;

import java.util.concurrent.TimeUnit;

public class WhatisThread {


    private static class MyThread extends Thread{

        @Override
        public void run() {
            for (int j=0;j<10;j++){
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("T1");


            }
        }
    }
//线程是 同一进程下不同的执行路径
    public static void main(String[]  args){

       // new MyThread().run();
        new MyThread().start();

        for(int i=0;i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main ");
        }
    }


}
