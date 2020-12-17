package thread.high.Atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class TetsCountAddThreeMethods {
	
	static AtomicLong count1 =new AtomicLong(0L);
	
	static Long count2 = 0L;
	
	static LongAdder count3 = new LongAdder();
	/**
	 * LongAdder类与AtomicLong类的区别在于高并发时前者将对单一变量的CAS操作分散为对数组cells中多个元素的CAS操作，
	 * 取值时进行求和；而在并发较低时仅对base变量进行CAS操作，与AtomicLong类原理相同。不得不说这种分布式的设计还是很巧妙的。
	 * */
	
	public static void main(String[] args) throws InterruptedException {
		
		long start ,end;
		
		Thread[] threads = new Thread[1000];
		
		for(int i=0;i<threads.length;i++) {		
			
			threads[i] = new Thread(()-> {
				for(int j=0;j<100000;j++) {
					count1.incrementAndGet();
				}
	
			});
			
			}
		 start = System.currentTimeMillis();
		
		for (Thread o : threads) {
			o.start();
		}
		for (Thread o : threads) {
			o.join();
		}
		
		 end = System.currentTimeMillis();
		System.out.println("count="+count1+"timeAtomiclong="+(end-start));
		
		Object lock = new Object();
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->{
				for(int j=0;j<100000;j++) {
				synchronized(lock) {
					count2++;
				}
			}
			});
		}
		 start = System.currentTimeMillis();

		for (Thread o : threads) {
			o.start();
		}
		for (Thread o : threads) {
			o.join();
		}
		
		 end = System.currentTimeMillis();
		System.out.println("count="+count1+"long="+(end-start));
	
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(()->{
				for(int j=0;j<100000;j++) {
				count3.increment();
				}
			}) ;
		}
		 start = System.currentTimeMillis();

		for (Thread o : threads) {
			o.start();
		}
		for (Thread o : threads) {
			o.join();
		}
		
		 end = System.currentTimeMillis();
		System.out.println("count="+count1+"longaddr="+(end-start));
	
	}

}
