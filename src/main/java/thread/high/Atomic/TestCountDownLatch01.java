/**
 * 容器会添加和计数 ，当添加了5个的时候要立刻提醒在继续是否添加
 * */
package thread.high.Atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author  limy
 * @date  2021年1月2日 下午3:57:01
 * @version 1.0
 */

/**
 * CountDownLatch 是能使一组线程等另一组线程都跑完了再继续跑 ,CountDownLatch.await() 方法在倒计数为0之前会阻塞当前线程.


 * */
public class TestCountDownLatch01 {
	
	
	
	List list = new ArrayList<>();
	
	public void add(Object o) {
		list.add(o);
	}
	
	public int getSize() {
		
		return list.size();
	}
	
	public static void main(String[] args) {
		TestCountDownLatch01 countDown = new TestCountDownLatch01();
		CountDownLatch count1 = new CountDownLatch(1);
		CountDownLatch count2 = new CountDownLatch(1);

		
		
		new Thread(()->{
			System.out.println("t2 start");
			System.out.println(countDown.getSize());
			// 此处不能用 if else 由于线程已经执行了一部分，被唤醒后接着执行刚才的判断不会重新再次执行，不会进入到else 里需要重新写判断让其执行
		/*	if(countDown.getSize()!=5) {
				try {
					count1.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				count2.countDown();//让t1 可以继续执行

			}*/
			if(countDown.getSize()!=5) {
				try {
					count1.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(countDown.getSize()==5) {
				
				count2.countDown();//让t1 可以继续执行
			}
			System.out.println("t2 end");
		}).start();
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(()->{
			System.out.println("t1 start");
			for (int i = 0; i < 10; i++) {
				countDown.add(i);
				System.out.println("i="+i);
				if(countDown.getSize()==5) {
					count1.countDown();// 放开 t2 让其可以被执行
					try {
						count2.await(); // 让t1 拦住，
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
			System.out.println("t1 end");
			
			
		}).start();
		
	}

}
