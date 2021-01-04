
package thread.high.Atomic;

import java.util.concurrent.Semaphore;

/**
 * @author  limy
 * @date  2020年12月30日 上午10:29:57
 * @version 1.0
 */
public class TestSemaphore {
	
	public static void main(String[] args) {
		//eg 车道 收费站  AQS 来实现里队列来控制
		//限流 1 只允许一个执行，执行结束后才允许别的线程执行 （参数允许同时执行的个数）
			Semaphore semaphore = new Semaphore(1);
			//Semaphore s = new Semaphore(2, true);  // 一堆
			
			//信号
			new Thread(()->{
				
				try {
					semaphore.acquire(); // Semaphore 的许可令牌
					System.out.println("T1 start");
					Thread.sleep(2000);
					System.out.println("T1 end");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					semaphore.release(); // 释放掉令牌
					
				}
				
			}).start();
			
			//信号
			new Thread(()->{
				
				try {
					semaphore.acquire(); // Semaphore 的许可令牌
					System.out.println("T2 start");
					Thread.sleep(200);
					System.out.println("T2 end");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					semaphore.release(); // 释放掉令牌
					
				}
				
			}).start();
		}
		
	}

