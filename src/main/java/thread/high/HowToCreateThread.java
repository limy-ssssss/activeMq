package thread.high;

public class HowToCreateThread {

    static class Mythread extends Thread{

        @Override
        public void run() {

            System.out.println("集成Thread");
        }
    }

    static class Myrun implements Runnable{


        @Override
        public void run() {
            System.out.println("实现runnable接口");
        }
    }

    //lamd 或多线程创建线程
}
