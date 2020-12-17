package thread.high;

/**个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
* 也就是说synchronized获得的锁是可重入的  
 * */

public class T3 {
	public synchronized void m1() { 
		System.out.println(Thread.currentThread().getName() + " m1 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
		System.out.println(Thread.currentThread().getName() + " m1 end");
	}
	
	public synchronized void m2() {
	
		System.out.println(Thread.currentThread().getName() + " m2 ");
	}
	
	public static void main(String[] args) {
		T3 t = new T3();
		t.m1();
	}
}
