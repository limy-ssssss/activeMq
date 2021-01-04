
package thread.high.Atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author  limy
 * @date  2020年12月30日 上午11:56:43
 * @version 1.0
 */
public class TestLockSupport {
	// wait await 使用的加锁的情况下，notify notifyall 唤醒某一个线程比较麻烦，不灵活
	// unpark 可以在park
	
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("i="+i);
					if(i==5) {
						LockSupport.park();
					}
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// TODO: handle finally clause
				}
				
			}
		});
		
		t.start();
		LockSupport.unpark(t);

	/*	try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LockSupport.unpark(t);
*/
	}

}
