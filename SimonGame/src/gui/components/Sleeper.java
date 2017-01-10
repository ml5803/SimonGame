package gui.components;

public class Sleeper implements Runnable{

	private int number;
	private int sleepTime;
	
	public static void main(String[] args) {
		Thread one = new Thread(new Sleeper(1));
		Thread two = new Thread(new Sleeper(2));
		Thread three = new Thread(new Sleeper(3));
		
		one.start();
		two.start();
		three.start();
	}
	
	public Sleeper(int number){
		this.number = number;
		this.sleepTime = (int)(1000*Math.random());
	}

	public void run() {
		try {
			System.out.println("Thread #" + number + " will sleep for " + sleepTime +" ms." );
			Thread.sleep(sleepTime);
			System.out.println("Thread #" + number + " woke up" );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
