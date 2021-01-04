package thread.high.Atomic;
/**
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * synchronized 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock04 {
	
	Lock lock = new ReentrantLock();
	
	void m1() {
		
		try {
		lock.lock();
			for (int i = 0; i < 10; i++) {
					TimeUnit.SECONDS.sleep(1);
				System.out.println("m1");
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	void m2() {
		boolean flah = false;
		try {
			flah =lock.tryLock(3,TimeUnit.SECONDS);
			System.out.println("m2 ..." + flah);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(flah) {
				//若获取到则进行解锁
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock04 r = new ReentrantLock04();
		Thread t1 = new Thread(r::m1);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread(r::m2);
		t2.start();
		
	/*	String a = "2002,2003,2004,";
		String b="1,";
		
    	a = "'" + a.replace(",", "','") + "'";

		a= "'" + a.replace(",", "','") + "'";
		b= "'" + b.replace(",", "','") + "'";
		System.out.println(a);//'1',''   '1','2','4','5',''
		System.out.println(a.lastIndexOf(","));
		//System.out.println(a.substring(0,a.lastIndexOf(",")));
		//System.out.println(b.substring(0,b.lastIndexOf(",")));
		a.lastIndexOf(",");*/

		
	}
	 



}
