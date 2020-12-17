package thread.high;

public class ThreadStatus {

    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println(this.getState());

            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();//此处可以逻辑处理
                }
            }
        }
    }

    public static void main(String[] args){
        Thread thread = new Thread();
        System.out.println(thread.getState());//NEW

        thread.start();
        System.out.println(thread.getState());//RUNNABLE
        System.out.println(thread.getStackTrace());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());//TERMINATED

    }
}
