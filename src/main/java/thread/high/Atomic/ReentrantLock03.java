package thread.high.Atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock03 {
	Lock lock = new ReentrantLock();

	void m1()  {
	
		try {
			lock.lock();
			for (int i = 0; i < 10; i++) {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("m1");
					m2();
				}
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} finally {
				lock.unlock();
			}
				
		
		
		
		
		
	}
	
	void m2() {
		try {
			lock.lock();
			System.out.println("m2");
		} finally {
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		ReentrantLock03 r = new ReentrantLock03();
		Thread t1 = new Thread(r::m1);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t2 = new Thread(r::m2);
		t2.start();
	}

}
