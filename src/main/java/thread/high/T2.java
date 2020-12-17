package thread.high;

/**个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
* 也就是说synchronized获得的锁是可重入的  父类有个同步方法，子类实现了父类也有同步方法， 子类可以调用父类的方法，若是不可重入就不是继承了
 * */
/**
 * m1 运行需要获取这把锁，但是m2运行不需要获取这把锁，同步方法和非同步方法可以同时被执行 ，这个易产生脏读问题（dirtyRead）
 * */
public class T2 {
	public synchronized void m1() { 
		System.out.println(Thread.currentThread().getName() + " m1 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " m1 end");
	}
	
	public void m2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " m2 ");
	}
	
	public static void main(String[] args) {
		T2 t = new T2();
		//写法一 lambda
		
		/*new Thread(()->t.m1(), "t1").start();
		new Thread(()->t.m2(), "t2").start();*/
		//写法二
		new Thread(t::m1, "t1").start();
		new Thread(t::m2, "t2").start();
		/*
		//
		new Thread(new Runnable() {

			@Override
			public void run() {
				t.m1();
			}
			
		});
		*/
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				t.m2();
			}
		}).start();
	}
}
