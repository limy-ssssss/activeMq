package thread.high;

public class T1 implements Runnable{
	
	private volatile int count =100;// 保证数据的可见性 ，添加了synchronized 就不用加了volatile
	
	@Override
	public synchronized void run() {//既保证原子性又保证了可见性
		count--;
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"count= "+count);
		//count--后未输出又被再次 --
		
	}
	
	public static void main(String[] args) {
		T1 t = new T1();
		
		for(int i=0;i<100;i++) {
			
			new Thread(t,"ThreadName"+i).start();
		}
		
	}

}
