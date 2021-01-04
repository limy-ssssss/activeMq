
package thread.high.Atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author  limy
 * @date  2021年1月3日 下午4:00:15
 * @version 1.0
 */
public class TestLockSupport02 {
	
volatile List lists = new ArrayList();

public void add(Object o) {
	lists.add(o);
}

public int size() {
	return lists.size();
}

public static void main(String[] args) {
	TestLockSupport02 c = new TestLockSupport02();

	CountDownLatch latch = new CountDownLatch(1);

	Thread t2 = new Thread(() -> {
		System.out.println("t2 start");
		if (c.size() != 5) {

			LockSupport.park();

		}
		System.out.println("t2  end ");


	}, "t2");

	t2.start();

	try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}

	new Thread(() -> {
		System.out.println("t1 start");
		for (int i = 0; i < 10; i++) {
			c.add(new Object());
			System.out.println("add " + i);

			if (c.size() == 5) {
				LockSupport.unpark(t2);
			}

			try {
				TimeUnit.SECONDS.sleep(1);  //此处若不睡眠，线程t1 执行很快 打印完了,线程t2 才执行
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}, "t1").start();

}
}
