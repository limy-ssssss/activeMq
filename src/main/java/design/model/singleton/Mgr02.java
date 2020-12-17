package design.model.singleton;

public class Mgr02 {




/**
 * 懒汉式
 * 多线程时会出现创建不同对象问题
 * 加锁 synchronized 给整个Mgr02.class 加锁
*/
    private static Mgr02 instance ;

    private Mgr02(){

    }

    public   static synchronized Mgr02 getInstance(){

       if(instance == null){

           try {
               Thread.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           instance = new Mgr02();

       }
       return  instance;
    }

    public static void main(String[] args){

        for (int i=0;i<100;i++){
        /*
            lamda表达式只有一个方法的匿名接口进行简写
        */

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Mgr02.getInstance().hashCode());
//            }
//        }).start();
  /*      new Thread(()->{
            System.out.println(Mgr02.getInstance().hashCode());

        }).start();
*/

        }
    }

}
