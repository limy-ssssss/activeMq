
package thread.high.Atomic;

import java.util.concurrent.Exchanger;

/**
 * @author  limy
 * @date  2020年12月30日 上午10:58:44
 * @version 1.0
 */
public class TestExchanger {
	//两个线程 放到一个队列里进行值交换完在进行执行线程， 不可逆的交换完后在进行交换
	 static Exchanger<String> exchanger = new Exchanger<>();

	    public static void main(String[] args) {
	        new Thread(()->{
	            String s = "T1";
	            try {
	                s = exchanger.exchange(s);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println(Thread.currentThread().getName() + " " + s);

	        }, "t1").start();


	        new Thread(()->{
	            String s = "T2";
	            try {
	                s = exchanger.exchange(s);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println(Thread.currentThread().getName() + " " + s);

	        }, "t2").start();


	    }

}
