package test;

public class MultiThreading {

	public static void main(String[] args) 
	{
		AmountTransfer t = new AmountTransfer();
		//Thread t1 = new Thread(new GLToCASA(t));
		//Thread t2 = new Thread(new CASAToIDBI(t));
		Runnable r1 = new GLToCASA(t);
		Runnable r2 = new CASAToIDBI(t);
		Thread t1 = new Thread(r1);  
		Thread t2 = new Thread(r2);  
		t1.start();
		t2.start();
	}

}

class AmountTransfer
{
	int totalAmount = 1000;
	public synchronized void amountTransfer(int amount)
	{
		for(int i=0; i<100; i++)
		{
			System.out.println(i+"  "+Thread.currentThread().getName());
		}
	}
}

class GLToCASA implements Runnable
{
	AmountTransfer t;
	GLToCASA(AmountTransfer t)
	{
		this.t = t;
	}
	@Override
	public void run()
	{
		t.amountTransfer(1500);
	}
}

class CASAToIDBI implements Runnable
{
	AmountTransfer t;
	
	CASAToIDBI(AmountTransfer t)
	{
		this.t = t;
	}
	@Override
	public void run()
	{
		t.amountTransfer(2500);
	}
}
