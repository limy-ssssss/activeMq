
package thread.high.Atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author  limy
 * @date  2020年12月28日 上午10:53:15
 * @version 1.0
 */
public class ReentrantLock06 extends Thread{
	
	private static ReentrantLock lock= new ReentrantLock(true);//不能保证一个线程执行完了必须是下一个线程执行， 相对的其他线程有可能获取到执行权 
	//默认是非公平锁
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName()+"获得锁");
				
			} finally {
				lock.unlock();
			}
			
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock06 r= new ReentrantLock06();
		
		Thread t1 = new Thread(r) ;
		
		Thread t2 = new Thread(r) ;
		
		t1.start();
		
		t2.start(); //若是synchronized 会一个线程执行完才会执行另一个线程
		
	}

}
