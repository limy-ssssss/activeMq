package thread.high.Atomic;

import java.util.concurrent.TimeUnit;

import org.apache.camel.util.Time;

public class ReentrantLock01 {
	
	synchronized void m1(){
		for (int i = 0; i < 10; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("m1");
			
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
		ReentrantLock01 r = new ReentrantLock01();
		Thread t1 = new Thread(r::m1);
		//特定对象::示例方法名 .函数式接口中被实现的方法的参数全部传给该实例方法作为参数 对应的Lambda表达式 (a,b...)->特定对象.实例方法(a,b...)

		t1.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 new Thread(r::m2).start(); //新线程 需要等待上一个线程结束才可以拿到锁
	}
}
