package thread.high.Atomic;

import java.util.concurrent.TimeUnit;

import org.apache.camel.util.Time;

public class ReentrantLock02 {
	
	synchronized void m1(){
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("m1");
				m2();//锁可以重入
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	synchronized void m2() {
		System.out.println("m2");
	}

	
	public static void main(String[] args) {
		ReentrantLock02 r = new ReentrantLock02();
		Thread t1 = new Thread(r::m1);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 new Thread(r::m2).start(); //新线程 需要等待上一个线程结束才可以拿到锁
	}
}
