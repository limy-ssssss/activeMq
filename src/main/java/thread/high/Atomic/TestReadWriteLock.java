
package thread.high.Atomic;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author  limy
 * @date  2020年12月29日 下午9:59:57
 * @version 1.0
 */
public class TestReadWriteLock {
	static Lock lock = new ReentrantLock();
	
	private static int value;
	
	static ReadWriteLock readWritelock = new ReentrantReadWriteLock();
	static Lock readLock = readWritelock.readLock();  // 读的时候不可以写但是可以同时读
	static Lock writeLock = readWritelock.writeLock();// 写的时候不可以读，也不可以同时写
	
	public static void read(Lock lock) {
		
		try {
			lock.lock();
            Thread.sleep(1000);
			System.out.println("read over!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void write(Lock lock ,int v) {
		try {
			lock.lock();
			Thread.sleep(1000);
			value = v;
			System.out.println("write over");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			 lock.unlock(); //一定要写否者线程不会自动结束
		}
	}
	
	public static void main(String[] args) {
	       //Runnable readR = ()-> read(lock);
        Runnable readR = ()-> read(readLock);

        //Runnable writeR = ()->write(lock, new Random().nextInt());
        Runnable writeR = ()->write(writeLock, new Random().nextInt());

        for(int i=0; i<18; i++) new Thread(readR).start(); 
        for(int i=0; i<2; i++) new Thread(writeR).start();


	}
	
	

}
