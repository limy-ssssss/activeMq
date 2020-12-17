package design.model.singleton;


/***
 * 解决了线程同步，防止反序列化
 * 枚举类 没有构造器
 */
public enum Mgr05 {

    INSTANCE;

    public void m(){

    }

    public static void main(String[] args){

        for (int i=0;i<100;i++){

          /*  new Thread(()->{
                System.out.println(Mgr05.INSTANCE.hashCode());
            }).start();*/
        }

    }
}
