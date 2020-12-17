package design.model.singleton;

public class Mgr04 {




/**
 * 静态内部类方式
 *jvm保证单例
 *加载外部类时不会加载内部类，这样可以实现懒加载，在调用方法初始化内部类时可以加载静态变量
 *
*/

    private Mgr04(){

    }
    //内部类
    private static class Mgr01Holder{
      private final static   Mgr04 mgr04 = new Mgr04();
    }

    public   static Mgr04 getInstance(){

        return  Mgr01Holder.mgr04;

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
 /*       new Thread(()->{
            System.out.println(Mgr04.getInstance().hashCode());

        }).start();
*/

        }
    }

}
