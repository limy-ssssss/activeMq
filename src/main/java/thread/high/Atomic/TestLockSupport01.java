
package thread.high.Atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author  limy
 * @date  2021年1月3日 下午4:00:15
 * @version 1.0
 */
public class TestLockSupport01 {
	
	List list = new ArrayList();
	
	public void add(Object o) {
		list.add(o);
	}
	
	public int getSize() {
		return list.size();
	}
	static Thread t1 =null ,  t2 =null;
	public static void main(String[] args) {
		TestLockSupport01 l = new TestLockSupport01();
		
		 t1 = new Thread(()->{
			System.out.println("t1 start");
				LockSupport.park();
				System.out.println(" t1 end ");
				LockSupport.unpark(t2);
	
		},"t1");
		t1.start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 t2 = new Thread(()->{
			System.out.println("t2 start");
				for (int i = 0; i < 10; i++) {
					
					l.add(i);
					System.out.println("i="+i);
					if(i==4) {
						LockSupport.unpark(t1);
						LockSupport.park();
					}
				}
			System.out.println("t2 end");
		},"t2");
		t2.start();

		
	}

}
