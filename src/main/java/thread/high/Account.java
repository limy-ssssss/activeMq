package thread.high;

import java.util.concurrent.TimeUnit;
/**
 *模拟银行账户 ，写加锁 ，读不加锁，出现脏读的现象
 * */
public class Account {
	
	String name;
	double balance;

	public synchronized void set(String name,double balance) {
		this.name = name;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.balance = balance;
	}
	
	public /*synchronized*/ double getBalance(String name) {
		
		return this.balance;
	}
	
	public static void main(String[] args) {
		
		Account account = new Account();
		
		new Thread(()-> account.set("li", 100.00)).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(account.getBalance("li"));
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(account.getBalance("li"));

	}
	
}
