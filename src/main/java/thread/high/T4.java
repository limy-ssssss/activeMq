package thread.high;

import java.util.concurrent.TimeUnit;


/**
 * eg:父类有个同步方法，子类实现了父类也有同步方法， 子类可以调用父类的方法，若是不可重入,父子类方法调用就会死锁。  
 * */
public class T4 {
	synchronized void m() {
		System.out.println("m start");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m end");
	}
	
	public static void main(String[] args) {
		new TT().m();// 都是锁的this对象，同一把锁
	}
	
}

class TT extends T4 {
	@Override
	synchronized void m() {
		System.out.println("child m start");
		super.m();
		System.out.println("child m end");
	}
}