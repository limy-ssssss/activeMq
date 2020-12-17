package design.model.singleton;

public class Mgr03 {




/**
 * 懒汉式
 * 多线程时会出现创建不同对象问题
 * 加锁 synchronized 给整个class 加锁
 * 使用代码块加锁的形式
 * 为什么加volatile  指令重排问题，没有初始时就返回instance(其是volatile可以保证即使java虚拟机对代码执行了指令重排序，也会保证它的正确性。)
 * (具体来说就是synchronized虽然保证了原子性，但却没有保证指令重排序的正确性，会出现A线程执行初始化，但可能因为构造函数里面的操作太多了，所以A线程的uniqueInstance实例还没有造出来，但已经被赋值了。而B线程这时过来了，错以为uniqueInstance已经被实例化出来，一用才发现uniqueInstance尚未被初始化。要知道我们的线程虽然可以保证原子性，但程序可能是在多核CPU上执行)
*/
    private static volatile Mgr03 instance ;

    private Mgr03(){

    }

    public   static Mgr03 getInstance(){

       if(instance == null){

           synchronized (Mgr03.class){
               if(instance == null) {
               try {
               Thread.sleep(1);
           } catch (InterruptedException e) {//半初始化，int值 ，0-》10 -》refer引用
               e.printStackTrace();
           }

                   instance = new Mgr03();
               }
           }
       }


       return  instance;
    }

    public static void main(String[] args){

        for (int i=0;i<100;i++){
        /*
            lamda表达式只有一个方法的匿名接口进行简写
        */

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Mgr02.getInstance().hashCode());
            }
        }).start();
        new Thread(()->{
            System.out.println(Mgr03.getInstance().hashCode());

        }).start();


        }
    }

}
